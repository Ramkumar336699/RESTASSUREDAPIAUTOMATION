package com.E2EAPIAutomationPractice.crud;

import com.E2EAPIAutomationPractice.endPoints.APIConstants;
import com.E2EAPIAutomationPractice.modules.PayloadManager;
import com.E2EAPIAutomationPractice.tests.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;


public class IntegrationTest extends BaseTest {

    PayloadManager payloadManager;
    String token;
    Integer bookingId;

    @Test
    @Owner("Ram kumar")
    @Description("#TC01 - Verify that the Status Code is 200 when we Create a Booking.")
    public void testCreateBooking() throws JsonProcessingException {

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        payloadManager = new PayloadManager();
        ValidatableResponse response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload())
                .post().then().log().all();
        response.time(Matchers.lessThan(10000L));
        response.statusCode(200);
        JsonPath jsonPath = response.extract().jsonPath();
        bookingId = jsonPath.get("bookingid");
        String firstName = jsonPath.get("booking.firstname");
        System.out.println(firstName);
        System.out.println("Booking is created and the bookingId is "+bookingId);
        Assert.assertNotNull(bookingId);
        Assertions.assertThat(bookingId).isNotNull();
        Assertions.assertThat(firstName).isEqualToIgnoringCase("nikiTHA").isNotEqualTo("Ram");
    }

    @Test
    @Owner("Ram kumar")
    @Description("#TC02 - Verify that the Status Code is 200 when we Create a Token.")
    public void testCreateToken() {

        requestSpecification.basePath(APIConstants.CREATE_TOKEN);
        payloadManager = new PayloadManager();
        ValidatableResponse response = RestAssured.given().spec(requestSpecification)
                .body(payloadManager.createToken())
                .post()
                .then().log().all()
                .statusCode(200);
        response.body("token", Matchers.notNullValue());
        response.body("token.length()",Matchers.equalTo(15));
        //Extract the token
        token = response.extract().path("token");
        System.out.println("The generated token is : "+token);
        Assertions.assertThat(token).isNotNull().hasSize(15);
    }

    @Owner("Ram kumar")
    @Description("#TC03 - Verify that the Status Code is 200 When we Update an existing Booking.")
    public void testUpdateBooking() throws JsonProcessingException {

        testCreateToken();
        testCreateBooking();
        payloadManager = new PayloadManager();
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING+bookingId);

        ValidatableResponse response = RestAssured.given().spec(requestSpecification)
                .contentType(ContentType.JSON)
                .cookie("token",token)
                .body(payloadManager.updatePayload())
                .when().put()
                .then().log().all()
                .assertThat().statusCode(200)
                .body("firstname", Matchers.equalTo("Rams"))
                .body("totalprice", Matchers.equalTo(112))
                .assertThat().body("firstname",Matchers.equalTo("Rams"));

        JsonPath jsonPath = response.extract().jsonPath();
        String firstName = jsonPath.getString("firstname");
        Assertions.assertThat(firstName).isEqualTo("Rams");

        testGetSingleBooking();
    }
    public void testGetSingleBooking() {
        payloadManager = new PayloadManager();
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING+bookingId);
        ValidatableResponse response = RestAssured.given().spec(requestSpecification)
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().all()
                .assertThat().statusCode(200);

        JsonPath jsonPath = response.extract().jsonPath();
        String firstName = jsonPath.getString("firstname");
        Assertions.assertThat(firstName).isEqualTo("Rams");

    }


}