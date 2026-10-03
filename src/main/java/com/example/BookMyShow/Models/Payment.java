package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Entity
public class Payment extends BaseEntity{

    private double amount;

    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    private String referenceNo;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

}
