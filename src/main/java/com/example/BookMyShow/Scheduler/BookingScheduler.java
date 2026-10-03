package com.example.BookMyShow.Scheduler;

import com.example.BookMyShow.Models.ShowSeat;
import com.example.BookMyShow.Models.ShowSeatStatus;
import com.example.BookMyShow.Repository.ShowSeatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingScheduler {
    private final ShowSeatRepo showSeatRepo;

    public void releaseExpiredSeats(){
        List<ShowSeat> showseats=showSeatRepo.findByShowSeatStatus(ShowSeatStatus.BLOCKED);
        
    }

}
