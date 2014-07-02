package com.dev9.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends PageObject {

    private By BY_RESULTS_WRAPPER = By.id("ires");
    private By BY_CITE = By.tagName("cite");
    private static final int MAX_WAIT_TIMEOUT_SEC = 5;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getCites() {
        waitUntilResultsLoaded();
        return driver.findElement(BY_RESULTS_WRAPPER).findElements(BY_CITE);
    }

    public void waitUntilResultsLoaded() {
        waitForElementPresence(BY_RESULTS_WRAPPER, MAX_WAIT_TIMEOUT_SEC);
    }

    public List<String> getSearchResults() {
        this.waitUntilResultsLoaded();
        List<WebElement> cites = this.getCites();

        List<String> citesList = new ArrayList<>();
        for (WebElement cite : cites) {
            citesList.add(cite.getText());
        }

        return citesList;
    }



}
