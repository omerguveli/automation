package com.automation.stepdefinitions.api;

import com.automation.services.api.CommentService;
import io.cucumber.java.en.When;

public class CommentSteps extends CommonApiSteps {

    private CommentService commentService;

    @When("I search for comments of post {int}")
    public void i_search_for_comments_of_post(int postId) {
        commentService = new CommentService(baseURI);
        response = commentService.getCommentsForPost(postId);
    }
}
