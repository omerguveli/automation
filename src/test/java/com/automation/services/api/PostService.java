package com.automation.services.api;

import com.automation.models.api.Post;
import com.automation.utilities.api.ApiUtils;
import io.restassured.response.Response;

public class PostService extends BaseService {

    private final String POSTS_ENDPOINT = "/posts";

    public PostService(String baseURI) {
        super(baseURI);
    }

    public Response getAllPosts() {
        return ApiUtils.getRequest(POSTS_ENDPOINT);
    }

    public Response getPost(int id) {
        return ApiUtils.getRequest(POSTS_ENDPOINT + "/" + id);
    }

    public Response createPost(Post post) {
        return ApiUtils.postRequest(POSTS_ENDPOINT, post);
    }

    public Response updatePost(int id, Post post) {
        return ApiUtils.putRequest(POSTS_ENDPOINT + "/" + id, post);
    }

    public Response deletePost(int id) {
        return ApiUtils.deleteRequest(POSTS_ENDPOINT + "/" + id);
    }
}
