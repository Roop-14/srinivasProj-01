package com.movie.ticket.booking.DTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import com.movie.ticket.booking.enums.BookingStatus;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
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
