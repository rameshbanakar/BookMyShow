package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseEntity{
    @ManyToOne
    @JoinColumn
    private Show show;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private int price;
}
