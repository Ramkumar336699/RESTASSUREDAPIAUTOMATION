package RESTAssuredAPIAutomation.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePUT {

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
    public void nonBDDStyle(){

        RequestSpecification rs = RestAssured.given();

        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("booking/1119");
        rs.cookie("token","ebb7cdc539f51d9");
        rs.contentType("application/json");
        rs.body(payload);
        Response response=rs.put();
        ValidatableResponse vr= response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Rams"));
        vr.body("lastname",Matchers.equalTo("Penkey"));

    }
}
