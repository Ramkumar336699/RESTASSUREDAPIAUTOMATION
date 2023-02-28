package RESTAssuredAPIAutomation.CRUD.GET;

import io.restassured.RestAssured;

public class BDDGETReq {

    public static void main(String[] args) {

        //Global Variables

        String BASE_URI = "https://restful-booker.herokuapp.com";
        RestAssured.baseURI = BASE_URI;

        RestAssured.given()
//                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .headers("Content-Type","application/json")
                .when().get()
                .then().log().all().statusCode(200);


    }
}
