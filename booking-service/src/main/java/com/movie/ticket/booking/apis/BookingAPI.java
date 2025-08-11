package com.movie.ticket.booking.apis;

import com.movie.ticket.booking.DTO.ResponseDTO;
import com.movie.ticket.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.ticket.booking.DTO.BookingDTO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("bookings")
@Slf4j
public class BookingAPI {
	@Autowired
	BookingService bookingService;

	@PostMapping
	public ResponseEntity<BookingDTO> createBooking(@Valid@RequestBody BookingDTO bookingDTO) {
        log.info("Entered into Handler method createBooking {}", bookingDTO);
		BookingDTO responseDTO=bookingService.createBooking(bookingDTO);
		return  new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
		
	}



}
