package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
}
