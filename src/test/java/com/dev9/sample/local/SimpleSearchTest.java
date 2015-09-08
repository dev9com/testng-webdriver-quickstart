package com.dev9.sample.local;


import com.dev9.annotation.MethodDriver;
import com.dev9.listener.SeleniumWebDriver;
import com.dev9.sample.SearchPage;
import com.dev9.sample.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Test
@Listeners({SeleniumWebDriver.class})
public class SimpleSearchTest {

    private List<String> results;

    // By specifying an excluded method the methodDriver variable will NOT be initialized for the listed methods.
    // This can be tested in the excluded method by the following assert: assertThat(methodDriver).isNull();
    @MethodDriver(excludeMethods = {"testNoWebDriverAssert"})
    public WebDriver methodDriver;

    public String search = "https://www.google.com/";

    // This test uses the WebDriver to search google for "Selenium Page Objects"
    // It then verifies the PageObject returned a non-null list of objects
    public void testSimpleSearch() {
        methodDriver.get(search);
        SearchPage searchPage = new SearchPage(methodDriver);
        SearchResultsPage searchResultsPage = searchPage.submitSearch("Selenium Page Objects");

        results = searchResultsPage.getSearchResults();

        assertThat(results).isNotNull();
        assertThat(results.size()).isGreaterThan(0);
    }

    // This test is to display the ability to disable the WebDriver for a test method.
    // It will only run if the testSimpleSearch test method found results
    @Test(dependsOnMethods = {"testSimpleSearch"})
    public void testNoWebDriverAssert() {
        assertThat(methodDriver).isNull();
        assertThat(results).contains("https://code.google.com/p/selenium/wiki/PageObjects");
    }
}
