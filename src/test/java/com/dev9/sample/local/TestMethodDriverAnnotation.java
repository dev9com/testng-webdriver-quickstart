package com.dev9.sample.local;

import com.dev9.annotation.MethodDriver;
import com.dev9.listener.SeleniumWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
@Listeners({SeleniumWebDriver.class})
public class TestMethodDriverAnnotation {


    @MethodDriver(excludeMethods = {"testExcluded"})
    public WebDriver methodDriver;

    public String search = "https://www.google.com/";

    public String maps = "https://www.google.com/maps";

    public String news = "https://news.google.com/";

    public void testGoogleSearch() {
        methodDriver.get(search);
        assertThat(methodDriver.getCurrentUrl()).isEqualTo(search);
    }

    public void testGoogleMaps() {
        methodDriver.get(maps);
        assertThat(methodDriver.getCurrentUrl()).startsWith(maps);
    }

    public void testGoogleNews() {
        methodDriver.get(news);
        assertThat(methodDriver.getCurrentUrl()).isEqualTo(news);
    }

    public void testExcluded() {
        assertThat(methodDriver).isNull();
    }
}