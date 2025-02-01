package ru.lashin.basic;

import ru.lashin.myExceptions.ClosedResourceException;
import ru.lashin.myExceptions.LossOfConnectionException;

import java.util.Random;

public class Connection implements AutoCloseable {
    private final String address;
    private boolean isOpen;

    public Connection(String address) {
        this.address = address;
        isOpen = true;
    }

    public String getData() throws LossOfConnectionException {
        if (!isOpen) throw new ClosedResourceException();
        Random random = new Random();
        if (random.nextInt(2) == 0) return address + "test connection";
        else throw new LossOfConnectionException("connection is closed");
    }

    @Override
    public void close() {
        isOpen = false;
    }
}
