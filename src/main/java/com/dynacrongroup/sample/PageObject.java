package com.dynacrongroup.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PageObject is a generate page from any given site.  It is designed to support the page object
 * design pattern, as described in http://code.google.com/p/selenium/wiki/PageObjects.
 *
 * Page objects are used to model a given page on a site, wrapping the individual calls to the
 * webDriver object.  The Page object provides services that are designed to model the functional
 * behavior of a given web page.
 */
public class PageObject {

    private final static Logger LOG = LoggerFactory.getLogger(PageObject.class);

    public WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public static PageObject getPage(WebDriver driver) {
        return PageFactory.initElements(driver, PageObject.class);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getBodyText() {
        return driver.findElement(By.tagName("Body")).getText();
    }

    public final WebElement waitForElementToBeClickable(By findByCondition, int waitInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, waitInSeconds).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(findByCondition));
        return driver.findElement(findByCondition);
    }

    public final WebElement waitForElementPresence(By findByCondition, int waitInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, waitInSeconds).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(findByCondition));
        return driver.findElement(findByCondition);
    }

    public final void waitForAbsenceOf(WebElement element, int waitInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, waitInSeconds);
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public final void waitForPresenceOfAllElements(By findByCondition, int waitInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, waitInSeconds).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findByCondition));
    }

    public final void waitForInvisibility(By findByCondition, int waitInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, waitInSeconds).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findByCondition));
    }

}
