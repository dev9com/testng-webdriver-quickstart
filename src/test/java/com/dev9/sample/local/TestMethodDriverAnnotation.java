package com.dev9.sample.local;

import com.dev9.webtest.annotation.MethodDriver;
import com.dev9.webtest.listeners.SeleniumWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test
@Listeners({SeleniumWebDriver.class})
public class TestMethodDriverAnnotation {


    @MethodDriver
    public WebDriver methodDriver;

    public String search = "https://www.google.com/";

    public String maps = "https://maps.google.com/";

    public String news = "https://news.google.com/";

    public void testMethod1() {
        methodDriver.get(search);
        Assert.assertTrue(methodDriver.getCurrentUrl().equals(search));
    }

    public void testMethod2() {
        methodDriver.get(maps);
        Assert.assertTrue(methodDriver.getCurrentUrl().equals(maps));
    }

    public void testMethod3() {
        methodDriver.get(news);
        Assert.assertTrue(methodDriver.getCurrentUrl().equals(news));
    }
}