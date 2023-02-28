package RESTAssuredAPIAutomation.GSON_Jackson.Exam1;

import RESTAssuredAPIAutomation.DiffTypePayloads.Booking.Booking;
import RESTAssuredAPIAutomation.DiffTypePayloads.Booking.BookingDates;
import com.google.gson.Gson;
import io.restassured.RestAssured;

public class Serialization {

    public static void main(String[] args) {

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

        // Do Serialization - Converting an Object to (Stream of Byte)JSON ==> Java Class to JSON


        Gson gson = new Gson();
        String bookingString = gson.toJson(booking);
        System.out.println(bookingString);


    }

}
