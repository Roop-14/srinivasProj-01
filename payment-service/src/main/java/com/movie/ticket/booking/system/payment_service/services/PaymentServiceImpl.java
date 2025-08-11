package com.movie.ticket.booking.system.payment_service.services;

import com.movie.ticket.booking.system.payment_service.ENUMS.BookingStatus;
import com.movie.ticket.booking.system.payment_service.ENUMS.PaymentStatus;
import com.movie.ticket.booking.system.payment_service.dtos.BookingDTO;
import com.movie.ticket.booking.system.payment_service.entities.PaymentEntity;
import com.movie.ticket.booking.system.payment_service.repositories.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.movie.ticket.booking.system.payment_service.ENUMS.PaymentStatus.PENDING;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    StripeApiPaymentGateway apiPaymentGateway;
    @Override
    @Transactional
    public BookingDTO makePayment(BookingDTO bookingDTO) {
        PaymentEntity paymentEntity = PaymentEntity.builder()
                .bookingId(bookingDTO.getBookingId())
                .bookingAmount(bookingDTO.getBookingAmount())
                .paymentStatus(PENDING)
                .paymentDateTime(LocalDateTime.now()) // ✅ FIX: prevent null at first save
                .build();

        paymentRepository.save(paymentEntity);
       bookingDTO= apiPaymentGateway.processPayment(bookingDTO);
       if (bookingDTO.getBookingStatus().equals(BookingStatus.CONFIRMED)){
           paymentEntity.setPaymentStatus(PaymentStatus.SUCCESS);
           paymentEntity.setPaymentDateTime(LocalDateTime.now());
       }
       else {
           paymentEntity.setPaymentStatus(PaymentStatus.FAILED);
           paymentEntity.setPaymentDateTime(LocalDateTime.now());
       }

        return bookingDTO;
    }
}
