package com.automation.stepdefinitions.api;

import com.automation.services.api.CommentService;
import com.automation.utilities.Log;
import io.cucumber.java.en.When;

public class CommentSteps {

    private CommentService commentService;

    @When("I search for comments of post {int}")
    public void i_search_for_comments_of_post(int postId) {
        Log.info("Searching for comments of post ID: " + postId);
        commentService = new CommentService(CommonApiSteps.baseURI);
        CommonApiSteps.response = commentService.getCommentsForPost(postId);
    }
}
