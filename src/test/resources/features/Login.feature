Feature: SauceDemo Login Functionality

  @smoke @regression
  Scenario: Login with valid credentials
    Given user is on the SauceDemo login page
    When user enters valid credentials
    And user clicks the login button
    Then user is navigated to the products page
