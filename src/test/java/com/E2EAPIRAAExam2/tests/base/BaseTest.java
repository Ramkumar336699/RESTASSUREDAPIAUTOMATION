package com.E2EAPIRAAExam2.tests.base;

import com.E2EAPIRAAExam2.actions.AssertActions;
import com.E2EAPIRAAExam2.endPoints.APIConstants;
import com.E2EAPIRAAExam2.modules.PayloadManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    Integer token;

    @BeforeMethod
    public void BaseTestHelper() {

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = (RequestSpecification) new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();
    }
    @AfterMethod
    public void tearDown(){
    }





}
