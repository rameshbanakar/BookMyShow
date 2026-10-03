package com.example.BookMyShow.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Seat extends BaseEntity{
    private String seatName;
    private int rowVal;
    private int colVal;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
}
