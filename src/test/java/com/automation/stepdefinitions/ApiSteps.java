package com.automation.stepdefinitions;

import com.automation.utilities.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiSteps {

    private Response response;

    @Given("I set the base URI to {string}")
    public void i_set_the_base_uri_to(String baseURI) {
        ApiUtils.setBaseURI(baseURI);
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = ApiUtils.getRequest(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String content) {
        Assert.assertTrue(response.getBody().asString().contains(content));
    }
}
