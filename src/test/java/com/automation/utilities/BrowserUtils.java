package com.automation.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {

    /**
     * Waits for the visibility of the element on the page.
     * Use this when interaction fails because element is not yet visible.
     * 
     * @param element The WebElement to wait for
     * @param seconds Max time to wait in seconds
     */
    public static void waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the element to be clickable.
     * Use this for buttons that might be covered or disabled initially.
     * 
     * @param element The WebElement to wait for
     * @param seconds Max time to wait in seconds
     */
    public static void waitForClickability(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
