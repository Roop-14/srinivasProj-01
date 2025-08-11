package com.movie.ticket.booking.handlers;

import com.movie.ticket.booking.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class BookingAPIHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.info("Inside methodArgumentNotValidException {}", exception.getMessage());
		List<String> allErrors=exception.getBindingResult().getAllErrors()
				.stream().map(ObjectError::getDefaultMessage).toList();

		return  new ResponseEntity<>(ResponseDTO.builder()
                .errorDescription(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.errorMsg(allErrors).build()
				, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseDTO> runtimeException(RuntimeException runtimeException){
		return new ResponseEntity<>(ResponseDTO.builder()
				.errorDescription(runtimeException.getMessage())
				.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

}
