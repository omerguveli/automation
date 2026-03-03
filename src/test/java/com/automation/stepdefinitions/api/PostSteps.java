package com.automation.stepdefinitions.api;

import com.automation.models.api.Post;
import com.automation.services.api.PostService;
import com.automation.utilities.Log;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PostSteps {

    private PostService postService;

    @When("I send a GET request for post {int}")
    public void i_send_a_get_request_for_post(int id) {
        Log.info("Sending GET request for post ID: " + id);
        postService = new PostService(CommonApiSteps.baseURI);
        CommonApiSteps.response = postService.getPost(id);
    }

    @When("I send a GET request to all posts")
    public void i_send_a_get_request_to_all_posts() {
        Log.info("Sending GET request for all posts");
        postService = new PostService(CommonApiSteps.baseURI);
        CommonApiSteps.response = postService.getAllPosts();
    }

    @When("I create a new post with title {string}, body {string}, and userId {int}")
    public void i_create_a_new_post_with_title_body_and_user_id(String title, String body, int userId) {
        Log.info("Creating a new post with title: " + title);
        postService = new PostService(CommonApiSteps.baseURI);
        Post postRequest = Post.builder()
                .title(title)
                .body(body)
                .userId(userId)
                .build();
        CommonApiSteps.response = postService.createPost(postRequest);
    }

    @When("I update post {int} with title {string} and body {string}")
    public void i_update_post_with_title_and_body(int id, String title, String body) {
        Log.info("Updating post ID: " + id + " with new title: " + title);
        postService = new PostService(CommonApiSteps.baseURI);
        Post updateRequest = Post.builder()
                .title(title)
                .body(body)
                .userId(1) // Defaulting for simple test
                .build();
        CommonApiSteps.response = postService.updatePost(id, updateRequest);
    }

    @When("I delete post {int}")
    public void i_delete_post(int id) {
        Log.info("Deleting post ID: " + id);
        postService = new PostService(CommonApiSteps.baseURI);
        CommonApiSteps.response = postService.deletePost(id);
    }

    @Then("the response title should be {string}")
    public void the_response_title_should_be(String expectedTitle) {
        Post postResponse = CommonApiSteps.response.as(Post.class);
        Assert.assertEquals(expectedTitle, postResponse.getTitle());
    }
}
