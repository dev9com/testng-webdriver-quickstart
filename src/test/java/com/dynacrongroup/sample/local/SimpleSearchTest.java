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

import static org.fest.assertions.api.Assertions.assertThat;


@Test
@Listeners({SeleniumWebDriver.class})

public class SimpleSearchTest {
    private final static Logger log = LoggerFactory.getLogger(SimpleSearchTest.class);

    private String SEARCH_TERM = "Selenium Page Objects";
    private String SEARCH_RESULTS_EXPECTED = "PageObjects - selenium - The Page Object pattern represents the ...";

    @MethodDriver
    public WebDriver methodDriver;

    public String search = "https://www.google.com/";


    public void testSimpleSearch() {
        methodDriver.get(search);
        SearchPage searchPage = new SearchPage(methodDriver);
        SearchResultsPage searchResultsPage = searchPage.submitSearch(SEARCH_TERM);

        log.info("Results displayed: " +searchResultsPage.getResultsContainerWebElementList().size());
        assertThat(searchResultsPage.getSearchResults()).contains(SEARCH_RESULTS_EXPECTED);

    }

}
