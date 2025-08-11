package com.movie.ticket.booking.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.ticket.booking.entitites.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, UUID>{

}
