package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.Seat;
import com.example.BookMyShow.Models.ShowSeat;
import com.example.BookMyShow.Models.ShowSeatStatus;
import com.example.BookMyShow.Repository.SeatRepo;
import com.example.BookMyShow.Repository.ShowSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeatService {
    private ShowSeatRepo showSeatRepo;
    @Autowired
    SeatService(ShowSeatRepo showSeatRepo){
        this.showSeatRepo=showSeatRepo;

    }

    public void seatBlocking(List<ShowSeat> showSeats){
        for(ShowSeat each:showSeats){
            each.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            each.setBlockedAt(new Date());
            showSeatRepo.save(each);
        }

    }

}
