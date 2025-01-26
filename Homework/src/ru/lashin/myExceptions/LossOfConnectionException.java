package ru.lashin.myExceptions;

public class LossOfConnectionException extends Exception {

    public LossOfConnectionException(String message){
        super(message);
    }

    public LossOfConnectionException(Throwable cause){
        super(cause);
    }

    public LossOfConnectionException(String message, Throwable cause){
        super(message, cause);
    }
}
