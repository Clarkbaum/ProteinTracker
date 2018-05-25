package com.simpleprogrammer.proteintracker;

public class InvalidGoalException extends Exception {
    //this constructer allows me to pass in a message
    public InvalidGoalException(String message) {
        super(message);
    }
}
