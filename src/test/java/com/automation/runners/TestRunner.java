package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com/automation/stepdefinitions", plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
}, tags = "@smoke or @regression or @api", monochrome = true, publish = true)
public class TestRunner {
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("com.automation.runners.TestRunner");
    }
}
