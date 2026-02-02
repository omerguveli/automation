package com.automation.stepdefinitions;

import com.automation.pages.SauceProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShoppingSteps {

    SauceProductsPage productsPage = new SauceProductsPage();

    @When("user adds {string} to the cart")
    public void user_adds_to_the_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Then("the cart badge should show {int} item")
    public void the_cart_badge_should_show_item(int count) {
        Assert.assertEquals(count, productsPage.getCartItemCount());
    }
}
