package com.dev9.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageObject {
    private By searchField = By.name("q");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage submitSearch(String searchTerm) {
        clearSearchField();
        driver.findElement(searchField).sendKeys(searchTerm);
        driver.findElement(searchField).sendKeys(Keys.RETURN);
        return new SearchResultsPage(driver);
    }

    private void clearSearchField() {
        driver.findElement(searchField).clear();
    }
}
