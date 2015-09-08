package com.dev9.sample;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchPage extends PageObject {

    @FindBy(name = "q") WebElement searchField;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public SearchResultsPage submitSearch(String searchTerm) {
        clearSearchField();
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new SearchResultsPage(driver);
    }

    private void clearSearchField() {
        searchField.clear();
    }
}
