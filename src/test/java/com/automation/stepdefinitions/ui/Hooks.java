package com.automation.stepdefinitions.ui;

import com.automation.utilities.ui.DriverFactory;
import com.automation.utilities.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        Log.info("Starting Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Log.error("Scenario Failed: " + scenario.getName());
            // Take Screenshot
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            // Attach screenshot to the report
            scenario.attach(screenshot, "image/png", "screenshot");
        } else {
            Log.info("Scenario Passed: " + scenario.getName());
        }
        
        DriverFactory.closeDriver();
    }
}
