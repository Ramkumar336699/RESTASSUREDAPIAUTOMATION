package com.E2EAPIAutomationPractice.tests.base;

import com.E2EAPIAutomationPractice.endPoints.APIConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public RequestSpecification requestSpecification;

    @BeforeMethod
    public void setUpConfig(){

        requestSpecification = (RequestSpecification) new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();

    }
}
