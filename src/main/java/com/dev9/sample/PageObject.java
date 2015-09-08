package com.dev9.sample;

import org.openqa.selenium.WebDriver;

/**
 * PageObject is a generate page from any given site.  It is designed to support the page object
 * design pattern, as described in http://code.google.com/p/selenium/wiki/PageObjects.
 *
 * Page objects are used to model a given page on a site, wrapping the individual calls to the
 * webDriver object.  The Page object provides services that are designed to model the functional
 * behavior of a given web page.
 */
public abstract class PageObject {

    protected final WebDriver driver;

    protected PageObject(WebDriver driver) {
        this.driver = driver;
    }
}
