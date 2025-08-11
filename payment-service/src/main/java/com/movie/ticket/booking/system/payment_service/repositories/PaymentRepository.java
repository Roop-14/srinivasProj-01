package com.movie.ticket.booking.system.payment_service.repositories;

import com.movie.ticket.booking.system.payment_service.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
}
