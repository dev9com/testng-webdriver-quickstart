package com.dynacrongroup.sample.local;


import com.dynacrongroup.sample.SearchPage;
import com.dynacrongroup.sample.SearchResultsPage;
import com.dynacrongroup.webtest.annotation.MethodDriver;
import com.dynacrongroup.webtest.listeners.SeleniumWebDriver;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


@Test
@Listeners({SeleniumWebDriver.class})
public class SimpleSearchTest {
    private final static Logger log = LoggerFactory.getLogger(SimpleSearchTest.class);

    private String SEARCH_TERM = "Selenium Page Objects";
    private String SEARCH_RESULTS_EXPECTED = "code.google.com/p/selenium/wiki/PageObjects";
    private List<String> SEARCH_RESULTS_FOUND;

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
        SearchResultsPage searchResultsPage = searchPage.submitSearch(SEARCH_TERM);

        SEARCH_RESULTS_FOUND = searchResultsPage.getSearchResults();

        assertThat(SEARCH_RESULTS_FOUND).isNotNull();
        log.info("Results displayed: " + SEARCH_RESULTS_FOUND.size());
        assertThat(SEARCH_RESULTS_FOUND.size()).isGreaterThan(0);
    }

    // This test is to display the ability to disable the WebDriver for a test method.
    // It will only run if the testSimpleSearch test method found results
    @Test(dependsOnMethods = {"testSimpleSearch"})
    public void testNoWebDriverAssert() {
        assertThat(methodDriver).isNull();
        assertThat(SEARCH_RESULTS_FOUND).contains(SEARCH_RESULTS_EXPECTED);
    }
}
