package com.E2EAPIAutomationPractice.actions;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response>{

    public static SoftAssertions softAssertions;

    public ResponseAssert(Response response) {
        super(response, ResponseAssert.class);
    }

    public static ResponseAssert assertThat(Response response) {
        return new ResponseAssert(response);
    }

    public ResponseAssert statusCodeIs(int expectedStatusCode){
        softAssertions.assertThat(actual.statusCode()).isEqualTo(expectedStatusCode);
        return this;
    }

    public ResponseAssert hasKeyWithValue(String key, String value){
        softAssertions.assertThat(actual.getBody().jsonPath().getString(key))
                .isEqualTo(value);
        return this;
    }

    public ResponseAssert hasContentType(String contentType){
        softAssertions.assertThat(actual.getContentType())
                .isEqualTo(contentType);
        return this;
    }

    public void assertAll(){
        softAssertions.assertAll();
    }

}


    /*public void verifyStatusCode(Response response) {
        assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"), true,
                "Value of status code is" + response.getStatusCode());
    }
    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(float actual, float expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(double actual, double expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(boolean actual, boolean expected, String description) {
        assertEquals(actual, expected, description);
    }*/



