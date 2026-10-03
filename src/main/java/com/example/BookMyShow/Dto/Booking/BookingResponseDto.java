package com.example.BookMyShow.Dto.Booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {
    private int amount;
    private int bookingId;
    private ResponseStatus respsonseStatus;
    private String message;
}
