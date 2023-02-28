package RESTAssuredAPIAutomation.CRUD.IntegrationScenarios.Scn1_CreateaToken_CreateBooking_UpdateBooking_DeleteBooking;

import RESTAssuredAPIAutomation.DiffTypePayloads.Booking.Booking;
import RESTAssuredAPIAutomation.DiffTypePayloads.Booking.BookingDates;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class Runner {

    public static void main(String[] args) {

        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;

        requestSpecification = RestAssured.given();
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(auth);

        response = requestSpecification.post();
        validatableResponse = response.then();
        //Validated the token generated
        validatableResponse.body("token",Matchers.notNullValue());
        validatableResponse.body("token.length()",Matchers.equalTo(15));

        //Extract the token
        String token = validatableResponse.extract().path("token");
        System.out.println("The generated token is : "+token);

        // For Assert we can use [Hamcrest, TestNG, AssertJ]
        // POST - To Create a Booking by using the above token generated

        Booking booking = new Booking();
        booking.setFirstname("Ram Kumar");
        booking.setLastname("Penkey");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2022-12-25");
        bookingdates.setCheckout("2022-12-30");

        booking.setBookingDates(bookingdates);
        booking.setAdditionalneeds("Breakfast and Lunch");

        Gson gson = new Gson();
        String bookingString = gson.toJson(booking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(bookingString);

        response= requestSpecification.post();
//        response.prettyPrint();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        JsonPath jsonPath = validatableResponse.extract().jsonPath();
        Integer bookingId = jsonPath.get("bookingid");
        System.out.println("Booking is created and the bookingId is "+bookingId);


        // Now Update the Booking by using BookingId and token which were generated already.
        Booking updateBooking = new Booking();
        updateBooking.setFirstname("Rams");
        updateBooking.setLastname("Penkey");
        updateBooking.setTotalprice(112);
        updateBooking.setDepositpaid(true);

        BookingDates bookingDates1 = new BookingDates();
        bookingDates1.setCheckin("2022-12-20");
        bookingDates1.setCheckout("2022-12-24");

        updateBooking.setBookingDates(bookingDates1);
        updateBooking.setAdditionalneeds("Breakfast, Lunch and Dinner");

        Gson gson1 = new Gson();
        String updateBookingContent = gson1.toJson(updateBooking);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .cookie("token",token)
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+bookingId)
                .body(updateBookingContent)
                .when().put()
                .then().log().all()
                .assertThat().statusCode(200)
                .body("firstname",Matchers.equalTo("Rams"))
                .body("totalprice",Matchers.equalTo(112));

        // Now Delete the Booking which was Created and updated already
        RestAssured.given()
                .contentType(ContentType.JSON)
                .cookie("token",token)
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+bookingId)
                .when().delete()
                .then().log().all()
                .assertThat().statusCode(201);

    }
}
