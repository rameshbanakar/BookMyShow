package com.example.BookMyShow.CustomeExceptions;

public class UserAlreadyFound extends RuntimeException{
    public UserAlreadyFound(String msg){
        super(msg);
    }
}
