package com.automation.pages;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    public SauceLoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(className = "title")
    public WebElement pageTitle;

    public void navigateToLogin() {
        DriverFactory.getDriver().get(com.automation.utilities.ConfigReader.getProperty("base_url"));
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        com.automation.utilities.BrowserUtils.waitForVisibility(loginButton, 10);
        loginButton.click();
    }

    public boolean isProductPageDisplayed() {
        return pageTitle.isDisplayed() && pageTitle.getText().equalsIgnoreCase("Products");
    }
}
