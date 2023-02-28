package RESTAssuredAPIAutomation.DiffTypePayloads.Booking;

import RESTAssuredAPIAutomation.DiffTypePayloads.Auth;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class POSTBDDStyle {

    public static void main(String[] args) {


        Auth payload = new Auth();
        payload.setUsername("admin");
        payload.setPassword("password123");


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

        System.out.println(booking);

       RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking").contentType("application/json")
                .body(booking)
                .when().post()
                .then().log().all()
                .statusCode(200);

    }
}
