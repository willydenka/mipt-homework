package ru.lashin.myExceptions;

public class MarkException extends RuntimeException {
    public MarkException(){
        super();
    }

    public MarkException(String message){
        super(message);
    }
}
