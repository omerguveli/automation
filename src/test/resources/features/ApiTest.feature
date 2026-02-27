Feature: API Verification

  @api
  Scenario: Verify Get Post API
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I send a GET request for post 1
    Then the response status code should be 200
    And the response should contain "userId"

  @api
  Scenario: Verify Create Post API
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I send a POST request to "/posts" with body:
      """
      {
        "title": "foo",
        "body": "bar",
        "userId": 1
      }
      """
    Then the response status code should be 201
    And the response should contain "foo"

  @api @pojo
  Scenario: Verify Create Post API with POJO
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I create a new post with title "POJO Title", body "POJO Body", and userId 1
    Then the response status code should be 201
    And the response title should be "POJO Title"

  @api
  Scenario: Verify Update Post API
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I update post 1 with title "Updated Title" and body "Updated Body"
    Then the response status code should be 200
    And the response title should be "Updated Title"

  @api
  Scenario: Verify Delete Post API
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I delete post 1
    Then the response status code should be 200

  @api @user
  Scenario: Verify User Creation and Deletion
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I create a new user with name "John Doe" and email "john@example.com"
    Then the response status code should be 201
    And the response user name should be "John Doe"
    When I delete user with id 1
    Then the response status code should be 200

  @api @comment
  Scenario: Verify Comments Search
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I search for comments of post 1
    Then the response status code should be 200
    And the response should contain "id"

  @api @user
  Scenario: Verify Get All Users
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I send a GET request for all users
    Then the response status code should be 200
    And the response should contain "Leanne Graham"

  @api @user
  Scenario: Verify Get Single User
    Given I set the base URI to "https://jsonplaceholder.typicode.com"
    When I send a GET request for user 1
    Then the response status code should be 200
    And the response user name should be "Leanne Graham"
