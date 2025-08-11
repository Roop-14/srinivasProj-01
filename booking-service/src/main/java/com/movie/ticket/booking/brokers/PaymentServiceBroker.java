package com.movie.ticket.booking.brokers;

import com.movie.ticket.booking.DTO.BookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Payment-service" ,url = "http://localhost:9091/payments")
public interface PaymentServiceBroker {



    @PostMapping()
    public BookingDTO makePayment(@RequestBody BookingDTO bookingDTO);




}
