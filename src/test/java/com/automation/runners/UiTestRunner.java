package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com/automation/stepdefinitions", plugin = {
        "pretty",
        "html:target/cucumber-ui.html",
        "json:target/cucumber-ui.json"
}, tags = "@smoke or @regression", monochrome = true)
public class UiTestRunner {
}
