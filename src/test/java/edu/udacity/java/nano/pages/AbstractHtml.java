package edu.udacity.java.nano.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractHtml {

    public WebDriver webDriver;

    public AbstractHtml(WebDriver driver) {
        this.webDriver = driver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public <T> WebDriverWait webDriverWait(long timeoutInSeconds) {
        return new WebDriverWait(this.webDriver, timeoutInSeconds);
    }
}
