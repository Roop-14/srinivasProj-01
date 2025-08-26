package com.ticket_booking.Api_Gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingAPIHandlerFallBack {
    @GetMapping("booking-fallback")
    public String bookingApifallBack(){

        return "Booking Service is in Maintenance Mode";

    }
}
