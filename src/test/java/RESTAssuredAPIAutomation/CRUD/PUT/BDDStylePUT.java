package RESTAssuredAPIAutomation.CRUD.PUT;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BDDStylePUT {
    String payload = "{\n" +
            "    \"firstname\": \"Rams\",\n" +
            "    \"lastname\": \"Penkey\",\n" +
            "    \"totalprice\": 111,\n" +
            "    \"depositpaid\": true,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2018-01-01\",\n" +
            "        \"checkout\": \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";

    @Test
    public void BDDStylePutRequest(){

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath(("/booking/1119"))
                .cookie("token","05b758afdb11243")
                .contentType("application/json")
                .body(payload)
                .when().put()
                .then().log().all()
                .statusCode(200)
                .body("firstname", Matchers.equalTo("Rams"))
                .body("lastname", Matchers.equalTo("Penkey"));
    }
}
