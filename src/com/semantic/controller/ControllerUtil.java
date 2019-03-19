package com.semantic.controller;

public class ControllerUtil {

    public static void validateTimestampParameter(String param) throws IllegalArgumentException{
        if (param == null || param.length() == 0){
            throw new IllegalArgumentException();
        }
    }
}
