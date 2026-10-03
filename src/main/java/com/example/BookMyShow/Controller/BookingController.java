package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dto.Booking.BookingRequestDto;
import com.example.BookMyShow.Dto.Booking.BookingResponseDto;
import com.example.BookMyShow.Dto.Booking.ResponseStatus;
import com.example.BookMyShow.Models.Booking;
import com.example.BookMyShow.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService=bookingService;

    }
    @GetMapping("/{id}")
    public BookingResponseDto getBookingById(@PathVariable("id") int bookingId){
        BookingResponseDto getDetails=new BookingResponseDto();
        return getDetails;
    }
    @PostMapping("/")
    public BookingResponseDto bookTicket(@RequestBody BookingRequestDto BookingRequestDto){
        BookingResponseDto bookingResponseDto =new BookingResponseDto();
        try{
            Booking booking=bookingService.bookTicket(BookingRequestDto.getShowId(),BookingRequestDto.getShowSeats(),BookingRequestDto.getUserId());
            bookingResponseDto.setBookingId(booking.getId());
            bookingResponseDto.setAmount(booking.getAmount());
            bookingResponseDto.setRespsonseStatus(ResponseStatus.SUCCESS);
            bookingResponseDto.setMessage("Successfully booked");
        }catch (Exception e){
             bookingResponseDto.setRespsonseStatus(ResponseStatus.FAILURE);
             bookingResponseDto.setMessage(e.getMessage());
        }
        return bookingResponseDto;
    }

}
