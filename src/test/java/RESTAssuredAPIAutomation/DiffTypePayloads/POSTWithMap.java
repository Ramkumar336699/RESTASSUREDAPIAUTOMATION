package RESTAssuredAPIAutomation.DiffTypePayloads;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class POSTWithMap {

    public static void main(String[] args) {

        /*// Payload
        String Payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";*/

        // I have added GSON or Jackson in dependencies that's why below Map is given in the form of InputStream
        Map<String,String> payload = new HashMap<>();
        payload.put("username","admin");
        payload.put("password","password123");

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
