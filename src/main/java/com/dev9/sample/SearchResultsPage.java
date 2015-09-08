package com.dev9.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(tagName = "cite") List<WebElement> cites;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public List<String> getSearchResults() {
        List<String> citesList = new ArrayList<>();
        for (WebElement cite : cites) {
            citesList.add(cite.getText());
        }

        return citesList;
    }
}
