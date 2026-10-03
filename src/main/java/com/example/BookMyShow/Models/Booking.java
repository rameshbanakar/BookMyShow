package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseEntity{
    @ManyToOne
    private User user;

    @OneToMany
    private List<ShowSeat> showSeats;

    @OneToMany
    private List<Payment> payment;

    private int amount;

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
