package com.example.BookMyShow.Dto.Booking;

import com.example.BookMyShow.Models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookingRequestDto {
    private  int userId;
    private int showId;
    private List<Integer> showSeats;
}
