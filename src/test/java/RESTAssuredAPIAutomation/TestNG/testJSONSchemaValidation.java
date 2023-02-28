package RESTAssuredAPIAutomation.TestNG;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class testJSONSchemaValidation {

    @Test
    public void testJSValidation(){

        //Global Variables
        String BASE_URI = "https://restful-booker.herokuapp.com";
        RestAssured.baseURI = BASE_URI;

        RestAssured
                .given()
                .basePath("/booking")
                .headers("Content-Type","application/json")
                .when().get()
                .then().log().all().statusCode(200);
//                .then().assertThat()
//                .body(JsonSchemaValidator.matchesJsonSchema(new File("")));
    }


}
