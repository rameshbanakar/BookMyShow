package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat,Integer> {
}
