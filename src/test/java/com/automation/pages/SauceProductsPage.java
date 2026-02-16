package com.automation.pages;

import com.automation.utilities.ui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceProductsPage {

    public SauceProductsPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    public void addProductToCart(String productName) {
        String buttonId = "add-to-cart-" + productName.toLowerCase().replace(" ", "-");
        org.openqa.selenium.By buttonLocator = By.id(buttonId);
        com.automation.utilities.ui.BrowserUtils.waitForPresence(buttonLocator, 10);
        DriverFactory.getDriver().findElement(buttonLocator).click();
    }

    public int getCartItemCount() {
        if (DriverFactory.getDriver().findElements(By.className("shopping_cart_badge")).isEmpty()) {
            return 0;
        }
        return Integer.parseInt(cartBadge.getText());
    }
}
