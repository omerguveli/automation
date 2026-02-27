package com.automation.stepdefinitions.api;

import com.automation.models.api.User;
import com.automation.services.api.UserService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserSteps extends CommonApiSteps {

    private UserService userService;

    @When("I create a new user with name {string} and email {string}")
    public void i_create_a_new_user_with_name_and_email(String name, String email) {
        userService = new UserService(baseURI);
        User userRequest = User.builder()
                .name(name)
                .email(email)
                .username(name.toLowerCase().replace(" ", "."))
                .build();
        response = userService.createUser(userRequest);
    }

    @When("I delete user with id {int}")
    public void i_delete_user_with_id(int id) {
        userService = new UserService(baseURI);
        response = userService.deleteUser(id);
    }

    @Then("the response user name should be {string}")
    public void the_response_user_name_should_be(String expectedName) {
        User userResponse = response.as(User.class);
        Assert.assertEquals(expectedName, userResponse.getName());
    }
}
