package com.automation.stepdefinitions.ui;

import com.automation.pages.SauceLoginPage;
import com.automation.utilities.ui.DriverFactory;
import com.automation.utilities.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    SauceLoginPage loginPage = new SauceLoginPage();

    @Given("user is on the SauceDemo login page")
    public void user_is_on_the_saucedemo_login_page() {
        Log.info("Navigating to SauceDemo login page");
        loginPage.navigateToLogin();
    }

    @Given("user enters valid credentials")
    public void user_enters_valid_credentials() {
        Log.info("Entering valid credentials");
        loginPage.enterUsername(com.automation.utilities.ConfigReader.getProperty("username"));
        loginPage.enterPassword(com.automation.utilities.ConfigReader.getProperty("password"));
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        Log.info("Clicking login button");
        loginPage.clickLogin();
    }

    @Then("user is navigated to the products page")
    public void user_is_navigated_to_the_products_page() {
        Log.info("Verifying products page is displayed");
        Assert.assertTrue("Products page should be displayed", loginPage.isProductPageDisplayed());
    }
}
