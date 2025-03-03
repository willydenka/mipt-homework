package ru.lashin.patterns.converter;

public class Converter {
    private final Openable openable;
    private final Convertable convertable;
    private final GetFileable getFileable;

    public Converter(Openable openable, Convertable convertable, GetFileable getFileable) {
        this.openable = openable;
        this.convertable = convertable;
        this.getFileable = getFileable;
    }

    public void convert(String inputName, String outputName) {
        String data = openable.open(inputName);
        String convertedData = convertable.convert(data);
        getFileable.getFile(convertedData, outputName);
    }
}
