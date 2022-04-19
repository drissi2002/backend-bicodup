package com.exam.backend.helper;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User with this username is not found In DB !");
    }

    public UserNotFoundException(String msg){
        super(msg);
    }
}
