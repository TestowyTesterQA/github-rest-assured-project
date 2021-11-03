package com;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.json.simple.*;
import java.io.FileNotFoundException;

public class Sample {

    @Test
        //TestNG annotation
    void postNewEmployees() throws FileNotFoundException {
        RestAssured.baseURI = "http://dummy.restapiexample.com";
        RequestSpecification httpRequest = RestAssured.given();

        //Here we created data through json object that we can send along with POST request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "abc");
        requestParams.put("age", "10");
        requestParams.put("salary", "10000");

        // specifying headers here, stating that the request body is json
        httpRequest.header("Content-Type", "application/json");

        // add the json body to the request payload
        httpRequest.body(requestParams.toJSONString());

        // Sending POST request
        Response response = httpRequest.request(Method.POST, "/api/v1/create");

        //capturing response body to perform validations
        String responseBody = response.getBody().asString();
        Reporter.log(responseBody); // to log the response

        // to capture response code through getStatusCode method.
        int status = response.getStatusCode();

        Assert.assertEquals(status, 200);
    }
}