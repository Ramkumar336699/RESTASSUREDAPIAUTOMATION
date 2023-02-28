package com.E2EAPIRAAExam2.modules;


import com.E2EAPIAutomationPractice.payloads.Auth;
import com.E2EAPIAutomationPractice.payloads.Booking;
import com.E2EAPIAutomationPractice.payloads.BookingDates;
import com.google.gson.Gson;


public class PayloadManager {
    Gson gson;
    public String createPayload() {

        Booking booking = new Booking();
        booking.setFirstname("Nikitha");
        booking.setLastname("Penkey");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2022-12-25");
        bookingdates.setCheckout("2022-12-30");
        booking.setBookingDates(bookingdates);
        booking.setAdditionalneeds("Breakfast and Lunch");

        gson = new Gson();
        String bookingString = gson.toJson(booking);
        return bookingString;
    }

    public String createToken(){

        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String authpayload = gson.toJson(auth);
        return authpayload;

    }

    public String updatePayload() {

        Booking updateBooking = new Booking();
        updateBooking.setFirstname("Rams");
        updateBooking.setLastname("Penkey");
        updateBooking.setTotalprice(112);
        updateBooking.setDepositpaid(true);

        BookingDates bookingDates2 = new BookingDates();
        bookingDates2.setCheckin("2022-12-20");
        bookingDates2.setCheckout("2022-12-24");

        updateBooking.setBookingDates(bookingDates2);
        updateBooking.setAdditionalneeds("Breakfast, Lunch and Dinner");

        Gson gson1 = new Gson();
        String updateBookingContent = gson1.toJson(updateBooking);
        return updateBookingContent;
    }
}
