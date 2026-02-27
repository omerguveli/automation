package com.automation.services.api;

import com.automation.models.api.Comment;
import com.automation.utilities.api.ApiUtils;
import io.restassured.response.Response;

public class CommentService extends BaseService {

    private final String COMMENTS_ENDPOINT = "/comments";

    public CommentService(String baseURI) {
        super(baseURI);
    }

    public Response getCommentsForPost(int postId) {
        return ApiUtils.getRequestSpec().queryParam("postId", postId).get(COMMENTS_ENDPOINT);
    }

    public Response createComment(Comment comment) {
        return ApiUtils.postRequest(COMMENTS_ENDPOINT, comment);
    }
}
