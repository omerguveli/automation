package com.automation.utilities.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public static RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();
    }

    public static Response getRequest(String endpoint) {
        return getRequestSpec().get(endpoint);
    }

    public static Response postRequest(String endpoint, Object body) {
        return getRequestSpec().body(body).post(endpoint);
    }

    public static Response deleteRequest(String endpoint) {
        return getRequestSpec().delete(endpoint);
    }

    public static Response putRequest(String endpoint, Object body) {
        return getRequestSpec().body(body).put(endpoint);
    }
}
