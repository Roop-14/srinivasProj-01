package com.movie.ticket.booking.system.payment_service.entities;



import com.movie.ticket.booking.system.payment_service.ENUMS.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "payments") // Optional: specify table name
public class PaymentEntity {

    @Id
    @GeneratedValue
    @Column(name = "payment_id", nullable = false, updatable = false)
    private UUID paymentId;

    @Column(name = "booking_id", nullable = false)
    @NotNull(message = "Booking ID is required")
    private UUID bookingId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    @NotNull(message = "Payment status is required")
    private PaymentStatus paymentStatus;

    @Column(name = "payment_amount", nullable = false)
    @NotNull(message = "Payment amount is required")
    @Positive(message = "Payment amount must be greater than zero")
    private Double bookingAmount;

    @Column(name = "payment_datetime", nullable = false)
    @NotNull(message = "Payment date-time is required")
    @PastOrPresent(message = "Payment date-time cannot be in the future")
    private LocalDateTime paymentDateTime;
}
