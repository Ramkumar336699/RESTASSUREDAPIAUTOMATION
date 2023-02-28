package RESTAssuredAPIAutomation.CRUD.POST;

import io.restassured.RestAssured;

public class BDDPOSTReq {

    public static void main(String[] args) {

        // Payload
        String Payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth").contentType("application/json")
                .body(Payload)
                .when().post()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}
