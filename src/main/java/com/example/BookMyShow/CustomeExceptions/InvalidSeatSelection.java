package com.example.BookMyShow.CustomeExceptions;

public class InvalidSeatSelection extends RuntimeException{
    public InvalidSeatSelection(String msg){
        super(msg);
    }
}
