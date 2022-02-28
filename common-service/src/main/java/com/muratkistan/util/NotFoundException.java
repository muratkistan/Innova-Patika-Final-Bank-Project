package com.muratkistan.util;

public class NotFoundException extends  RuntimeException {
    public NotFoundException(String message){
        super(message + " Not Found!");
    }
}
