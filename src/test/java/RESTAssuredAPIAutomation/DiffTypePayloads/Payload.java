package RESTAssuredAPIAutomation.DiffTypePayloads;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Payload {

    public static void main(String[] args) {

        //Payload
        Auth payload =new Auth();
        payload.setUsername("admin");
        payload.setPassword("password123");

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType("application/json");
        rs.body(payload);

        Response response=rs.post();
        ValidatableResponse vr= response.then().log().all();
        vr.statusCode(200);
    }

}
