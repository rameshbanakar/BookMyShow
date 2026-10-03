package com.example.BookMyShow.CustomeExceptions;

public class ShowNotFound extends RuntimeException{
    public ShowNotFound(String msg){
        super(msg);
    }
}
