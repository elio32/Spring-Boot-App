package com.lhind.internship.springbootfirstprogram.SpringBootApp.exception;

public class UserNotFoundException extends Exception{
    private static final String message = "User does not exist";

    public UserNotFoundException() {
        super(message);
    }

}
