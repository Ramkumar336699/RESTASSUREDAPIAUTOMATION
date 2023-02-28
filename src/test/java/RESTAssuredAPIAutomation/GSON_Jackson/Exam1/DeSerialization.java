package RESTAssuredAPIAutomation.GSON_Jackson.Exam1;

import RESTAssuredAPIAutomation.DiffTypePayloads.Booking.Booking;
import com.google.gson.Gson;

public class DeSerialization {

    public static void main(String[] args) {

        // Converting JSON back to an Objects

        String json = "{\n" +
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

        Gson gson = new Gson();
        Booking booking = gson.fromJson(json,Booking.class);
        System.out.println(booking.getBookingDates());
        System.out.println(booking.getTotalprice());


    }
}
