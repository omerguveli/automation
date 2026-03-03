package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "com.automation.stepdefinitions.api",
        plugin = {
                "pretty",
                "html:target/cucumber-api-reports.html",
                "json:target/cucumber-api.json",
                "junit:target/cucumber-api.xml",
                "rerun:target/rerun.txt"
        },
        tags = "@api",
        monochrome = true,
        publish = true
)
public class ApiTestRunner {
}
