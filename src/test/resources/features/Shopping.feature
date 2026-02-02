Feature: Shopping Cart Functionality

  Background:
    Given user is on the SauceDemo login page
    When user enters valid credentials
    And user clicks the login button

  @shopping @regression
  Scenario: Add product to cart
    When user adds "Sauce Labs Backpack" to the cart
    Then the cart badge should show 1 item
