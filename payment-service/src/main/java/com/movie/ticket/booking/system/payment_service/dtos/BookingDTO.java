package com.movie.ticket.booking.system.payment_service.dtos;

import com.movie.ticket.booking.system.payment_service.ENUMS.BookingStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Validated
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class BookingDTO {
    private UUID bookingId;
    @NotBlank(message = "User ID is mandatory")
    private String userId;

    @NotNull(message = "Movie ID must not be null")
    private Integer movieId;

    @NotEmpty(message = "At least one seat must be selected")
    private List<@NotBlank(message = "Seat value must not be blank") String> seatsSelected;

    @NotNull(message = "Show date must not be null")
    @FutureOrPresent(message = "Show date must be today or in the future")
    private LocalDate showDate;

    @NotNull(message = "Show time must not be null")
    private LocalTime showTime;

  @Enumerated(EnumType.STRING)
   private BookingStatus bookingStatus;

    @NotNull(message = "Booking amount must not be null")
    @Positive(message = "Booking amount must be positive")
    private Double bookingAmount;



}
