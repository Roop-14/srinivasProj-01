package com.movie.ticket.booking.service;

import com.movie.ticket.booking.DTO.BookingDTO;
import com.movie.ticket.booking.DTO.ResponseDTO;
import com.movie.ticket.booking.brokers.PaymentServiceBroker;
import com.movie.ticket.booking.entitites.BookingEntity;
import com.movie.ticket.booking.enums.BookingStatus;
import com.movie.ticket.booking.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplBookingService implements BookingService {
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	PaymentServiceBroker serviceBroker;
	@Override
	@Transactional
	public BookingDTO createBooking(BookingDTO bookingDTO) {
		BookingEntity bookingEntity=new BookingEntity();
		BeanUtils.copyProperties(bookingDTO,bookingEntity);
		bookingEntity.setBookingStatus(BookingStatus.PENDING);
		BookingEntity savedbookingEntity=bookingRepository.save(bookingEntity);

		// Update bookingDTO with generated fields if needed
		BeanUtils.copyProperties(savedbookingEntity, bookingDTO);

		BookingDTO updatedbookingDto=serviceBroker.makePayment(bookingDTO);
		savedbookingEntity.setBookingStatus(updatedbookingDto.getBookingStatus());
		bookingRepository.save(savedbookingEntity);

		return updatedbookingDto;
	}

}
