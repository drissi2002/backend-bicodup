package com.exam.backend.helper;

public class UserFoundException extends Exception {
    public UserFoundException() {
        super("User with this username is already In DB !");
    }

    public UserFoundException(String msg){
        super(msg);
    }
}
