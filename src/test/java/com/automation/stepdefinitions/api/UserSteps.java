package com.automation.stepdefinitions.api;

import com.automation.models.api.User;
import com.automation.services.api.UserService;
import com.automation.utilities.Log;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserSteps {

    private UserService userService;

    @When("I create a new user with name {string} and email {string}")
    public void i_create_a_new_user_with_name_and_email(String name, String email) {
        Log.info("Creating a new user with name: " + name);
        userService = new UserService(CommonApiSteps.baseURI);
        User userRequest = User.builder()
                .name(name)
                .email(email)
                .username(name.toLowerCase().replace(" ", "."))
                .build();
        CommonApiSteps.response = userService.createUser(userRequest);
    }

    @When("I delete user with id {int}")
    public void i_delete_user_with_id(int id) {
        Log.info("Deleting user with ID: " + id);
        userService = new UserService(CommonApiSteps.baseURI);
        CommonApiSteps.response = userService.deleteUser(id);
    }

    @When("I send a GET request for all users")
    public void i_send_a_get_request_for_all_users() {
        Log.info("Fetching all users");
        userService = new UserService(CommonApiSteps.baseURI);
        CommonApiSteps.response = userService.getAllUsers();
    }

    @When("I send a GET request for user {int}")
    public void i_send_a_get_request_for_user(int id) {
        Log.info("Fetching user with ID: " + id);
        userService = new UserService(CommonApiSteps.baseURI);
        CommonApiSteps.response = userService.getUser(id);
    }

    @Then("the response user name should be {string}")
    public void the_response_user_name_should_be(String expectedName) {
        User userResponse = CommonApiSteps.response.as(User.class);
        Assert.assertEquals(expectedName, userResponse.getName());
    }
}
