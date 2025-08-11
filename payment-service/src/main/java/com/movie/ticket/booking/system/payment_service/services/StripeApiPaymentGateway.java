package com.movie.ticket.booking.system.payment_service.services;

import com.movie.ticket.booking.system.payment_service.ENUMS.BookingStatus;
import com.movie.ticket.booking.system.payment_service.dtos.BookingDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class StripeApiPaymentGateway {
    @Value("${stripe.key}")
    private String apiKey;

    @PostConstruct
    public void init(){
        Stripe.apiKey=apiKey;
    }

    public BookingDTO processPayment(BookingDTO bookingDTO){
        Double bookingAmount = bookingDTO.getBookingAmount();
        Long amountInPaise = (long) (bookingAmount * 100);
        Map<String,Object> chargeParams=new HashMap<>();
        chargeParams.put("amount",amountInPaise);
        chargeParams.put("currency","inr");
        chargeParams.put("description","Test Payment for Booking Service");
        chargeParams.put("source","tok_in");

        try {
            Charge.create(chargeParams);
            bookingDTO.setBookingStatus(BookingStatus.CONFIRMED);
        } catch (StripeException e) {
            log.error("error encountered during payment prices:%s".formatted(e.getMessage()));
            bookingDTO.setBookingStatus(BookingStatus.CANCELLED);
        }

        return bookingDTO;


    }



}
