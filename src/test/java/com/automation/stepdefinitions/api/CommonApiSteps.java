package com.automation.stepdefinitions.api;

import com.automation.utilities.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class CommonApiSteps {

    protected static Response response;
    protected static String baseURI;

    @Given("I set the base URI to {string}")
    public void i_set_the_base_uri_to(String baseURI) {
        CommonApiSteps.baseURI = baseURI;
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String content) {
        Assert.assertTrue(response.getBody().asString().contains(content));
    }

    @When("I send a POST request to {string} with body:")
    public void i_send_a_post_request_to_with_body(String endpoint, String body) {
        response = ApiUtils.postRequest(endpoint, body);
    }
}
