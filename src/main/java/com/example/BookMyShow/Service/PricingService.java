package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.SeatType;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.ShowSeat;
import com.example.BookMyShow.Models.ShowSeatType;
import com.example.BookMyShow.Repository.ShowSeatRepo;
import com.example.BookMyShow.Repository.ShowSeatTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PricingService {
    private final ShowSeatTypeRepo showSeatTypeRepo;
    private final ShowSeatRepo showSeatRepo;

    public int caluculateSeatPrice(List<ShowSeat> showSeat, Show show){
        int amount=0;
        for(ShowSeat each:showSeat){
            ShowSeat showSeatdb=showSeatRepo.findBySeatAndShow(each,show);
            SeatType seatType=showSeatdb.getSeat().getSeatType();
            ShowSeatType ShowSeatTypedb=showSeatTypeRepo.findByShowAndSeatType(show,seatType);
            amount+=ShowSeatTypedb.getPrice();
        }
        return amount;
    }

}
