package com.automation.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public static Response getRequest(String endpoint) {
        RequestSpecification request = RestAssured.given();
        request.header("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        request.header("Accept", "application/json");
        return request.get(endpoint);
    }

    public static Response postRequest(String endpoint, Object body) {
        RequestSpecification request = RestAssured.given();
        request.header("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        request.header("Content-Type", "application/json");
        request.body(body);
        return request.post(endpoint);
    }
}
