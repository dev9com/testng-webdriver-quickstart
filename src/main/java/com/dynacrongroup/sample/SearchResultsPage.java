package com.dynacrongroup.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends PageObject {

    private By BY_RESULTS_WRAPPER = By.id("ires");
    private By BY_RESULT = By.className("s");
    private By BY_RESULT_TEST = By.className("_Zd");
    private static final int MAX_WAIT_TIMEOUT_SEC = 5;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getResultsContainerWebElementList() {
        waitUntilResultsLoaded();
        return driver.findElement(BY_RESULTS_WRAPPER).findElements(BY_RESULT);
    }

    public void waitUntilResultsLoaded() {
        waitForElementPresence(BY_RESULTS_WRAPPER, MAX_WAIT_TIMEOUT_SEC);
    }

    public List<String> getSearchResults() {
        this.waitUntilResultsLoaded();
        List<WebElement> searchResults = this.getResultsContainerWebElementList();

        List<String> propertyList = new ArrayList<>();
        for (WebElement parent : searchResults) {
            propertyList.add(parent.findElement(BY_RESULT_TEST).getText());
        }

        return propertyList;
    }



}
