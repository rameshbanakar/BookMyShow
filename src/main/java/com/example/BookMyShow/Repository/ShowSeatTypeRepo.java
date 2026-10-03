package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.SeatType;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.ShowSeat;
import com.example.BookMyShow.Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepo extends JpaRepository<ShowSeatType,Integer> {
    ShowSeatType findByShowAndSeatType(Show show, SeatType seatType);
}
