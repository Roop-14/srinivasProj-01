package com.movie.ticket.booking.system.payment_service.services;

import com.movie.ticket.booking.system.payment_service.dtos.BookingDTO;

public interface PaymentService {

    public BookingDTO makePayment(BookingDTO bookingDTO);
}
