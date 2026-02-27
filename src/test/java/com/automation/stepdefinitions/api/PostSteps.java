package com.automation.stepdefinitions.api;

import com.automation.models.api.Post;
import com.automation.services.api.PostService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PostSteps extends CommonApiSteps {

    private PostService postService;

    @When("I send a GET request for post {int}")
    public void i_send_a_get_request_for_post(int id) {
        postService = new PostService(baseURI);
        response = postService.getPost(id);
    }

    @When("I send a GET request to all posts")
    public void i_send_a_get_request_to_all_posts() {
        postService = new PostService(baseURI);
        response = postService.getAllPosts();
    }

    @When("I create a new post with title {string}, body {string}, and userId {int}")
    public void i_create_a_new_post_with_title_body_and_user_id(String title, String body, int userId) {
        postService = new PostService(baseURI);
        Post postRequest = Post.builder()
                .title(title)
                .body(body)
                .userId(userId)
                .build();
        response = postService.createPost(postRequest);
    }

    @Then("the response title should be {string}")
    public void the_response_title_should_be(String expectedTitle) {
        Post postResponse = response.as(Post.class);
        Assert.assertEquals(expectedTitle, postResponse.getTitle());
    }
}
