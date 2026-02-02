package com.automation.stepdefinitions;

import com.automation.pages.SauceLoginPage;
import com.automation.utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    SauceLoginPage loginPage = new SauceLoginPage();

    @Given("user is on the SauceDemo login page")
    public void user_is_on_the_saucedemo_login_page() {
        loginPage.navigateToLogin();
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.enterUsername(com.automation.utilities.ConfigReader.getProperty("username"));
        loginPage.enterPassword(com.automation.utilities.ConfigReader.getProperty("password"));
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("user is navigated to the products page")
    public void user_is_navigated_to_the_products_page() {
        Assert.assertTrue("Products page should be displayed", loginPage.isProductPageDisplayed());
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
