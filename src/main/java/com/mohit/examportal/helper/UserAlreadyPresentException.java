package com.mohit.examportal.helper;

public class UserAlreadyPresentException extends Exception{
    public UserAlreadyPresentException(String s) {
        super(s);
    }
}
