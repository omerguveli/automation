package com.automation.services.api;

import com.automation.models.api.User;
import com.automation.utilities.api.ApiUtils;
import io.restassured.response.Response;

public class UserService extends BaseService {

    private final String USERS_ENDPOINT = "/users";

    public UserService(String baseURI) {
        super(baseURI);
    }

    public Response getAllUsers() {
        return ApiUtils.getRequest(USERS_ENDPOINT);
    }

    public Response getUser(int id) {
        return ApiUtils.getRequest(USERS_ENDPOINT + "/" + id);
    }

    public Response createUser(User user) {
        return ApiUtils.postRequest(USERS_ENDPOINT, user);
    }

    public Response deleteUser(int id) {
        return ApiUtils.deleteRequest(USERS_ENDPOINT + "/" + id);
    }
}
