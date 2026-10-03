package com.example.BookMyShow.CustomeExceptions;

public class InvlidInput  extends RuntimeException{
    public InvlidInput(String msg){
        super(msg);
    }
}
