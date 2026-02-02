package com.automation.pages;

import com.automation.utilities.DriverFactory;
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
        // Dynamic locator: The add to cart button ID depends on the product name
        // Example: Sauce Labs Backpack -> add-to-cart-sauce-labs-backpack
        String buttonId = "add-to-cart-" + productName.toLowerCase().replace(" ", "-");
        DriverFactory.getDriver().findElement(By.id(buttonId)).click();
    }

    public int getCartItemCount() {
        if (DriverFactory.getDriver().findElements(By.className("shopping_cart_badge")).isEmpty()) {
            return 0;
        }
        return Integer.parseInt(cartBadge.getText());
    }
}
