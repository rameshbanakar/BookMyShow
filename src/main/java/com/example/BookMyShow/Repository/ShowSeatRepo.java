package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.ShowSeat;
import com.example.BookMyShow.Models.ShowSeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepo extends JpaRepository<ShowSeat,Integer> {
    List<ShowSeat> findAllByIdIn(List<ShowSeat> showSeats);

    ShowSeat findBySeatAndShow(ShowSeat each, Show show);
    List<ShowSeat> findByShowSeatStatus(ShowSeatStatus bookingStatus);

}
