Feature: API Verification

  @api
  Scenario: Verify Get Post API
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response should contain "userId"
