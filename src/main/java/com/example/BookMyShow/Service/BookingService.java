package com.example.BookMyShow.Service;

import com.example.BookMyShow.CustomeExceptions.InvalidSeatSelection;
import com.example.BookMyShow.CustomeExceptions.ShowNotFound;
import com.example.BookMyShow.CustomeExceptions.UserNotFound;
import com.example.BookMyShow.Dto.Booking.BookingRequestDto;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.ShowRepo;
import com.example.BookMyShow.Repository.ShowSeatRepo;
import com.example.BookMyShow.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final UserRepo userRepo;
    private final ShowRepo showRepo;
    private final ShowSeatRepo showSeatRepo;
    private final PricingService pricingService;
    private final SeatService seatService;
    private final PaymentService paymentService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(int showId, List<Integer> showSeats, int userId) {
//         data validation

        Optional<User> user=userRepo.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFound("user not found with the id"+userId);
        }

        User userDb=user.get();

        Optional<Show> show=showRepo.findById(showId);
        if(show.isEmpty()){
            throw new ShowNotFound("Show did not found with the "+ showId);
        }

        Show showdb=show.get();

        List<ShowSeat> showSeat=showSeatRepo.findAllById(showSeats);

        for(ShowSeat each:showSeat){
            if(!each.getShowSeatStatus().equals(ShowSeatStatus.EMPTY)){
                throw new InvalidSeatSelection("User has selected Invalid seats");
            }
        }

        List<ShowSeat> showSeatDb=new ArrayList<>();
        for(ShowSeat each:showSeat){
            each.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            each.setBlockedAt(new Date());
            ShowSeat showSeatSaved=showSeatRepo.save(each);
            showSeatDb.add(showSeatSaved);
        }

        seatService.seatBlocking(showSeat);

        int amount=pricingService.caluculateSeatPrice(showSeatDb,showdb);
        Booking book=new Booking();
        Payment payment=paymentService.createPayment(book.getId(),amount);

        if(payment.getPaymentStatus().equals(PaymentStatus.SUCCESS)){
            book.setAmount(amount);
            book.setUser(userDb);
            book.setShow(showdb);
            book.setShowSeats(showSeatDb);
            book.setTicketStatus(TicketStatus.SUCCESS);
//            book.setPayment(payment);
        }

//      user exist or not
        return book;
    }
}
