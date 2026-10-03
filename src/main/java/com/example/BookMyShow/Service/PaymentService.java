package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.Payment;
import com.example.BookMyShow.Models.PaymentMode;
import com.example.BookMyShow.Models.PaymentStatus;
import com.example.BookMyShow.Repository.BookingRepo;
import com.example.BookMyShow.Repository.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final BookingRepo bookingRepo;
    private final PaymentRepo paymentRepo;

    public Payment createPayment(int bookingId, int amount){
        Payment payment= new Payment();
        payment.setPaymentMode(PaymentMode.DC);
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        paymentRepo.save(payment);
       return payment;
    }


}
