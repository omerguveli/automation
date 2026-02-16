package com.automation.stepdefinitions.ui;

import com.automation.pages.SauceProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShoppingSteps {

    SauceProductsPage productsPage = new SauceProductsPage();

    @When("user adds {string} to the cart")
    public void user_adds_to_the_cart(String productName) {
        com.automation.utilities.Log.info("Adding product to cart: " + productName);
        productsPage.addProductToCart(productName);
    }

    @Then("the cart badge should show {int} item")
    public void the_cart_badge_should_show_item(int count) {
        com.automation.utilities.Log.info("Verifying cart badge count is: " + count);
        Assert.assertEquals(count, productsPage.getCartItemCount());
    }
}
