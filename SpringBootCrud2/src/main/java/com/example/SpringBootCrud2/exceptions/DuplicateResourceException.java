package com.example.SpringBootCrud2.exceptions;

public class DuplicateResourceException  extends RuntimeException{
    public DuplicateResourceException(String message){
        super(message);
    }
}
