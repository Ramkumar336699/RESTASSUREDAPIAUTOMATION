package RESTAssuredAPIAutomation.CRUD.Others;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class ResponseTime {

    public static void main(String[] args) {

        // BDD Style
        /*RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when().get()
                .then().log().all()
                .time(Matchers.lessThan(2000L));*/

        // Non-BDD Style

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");

        Response response = rs.put();

        ValidatableResponse vr = response.then();
        vr.time(Matchers.lessThan(2000L));



    }
}
