package ru.lashin.spring.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Data {
    String pathFrom;
    String pathTo;
    List<String> data = new ArrayList<>();
    List<Consumer<Data>> actions = new ArrayList<>();
    {
        data.add("trf");
        data.add("adafsg");
        data.add("апва");
    }

    public Data(String pathFrom, String pathTo) {
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
    }

    public void addAction(Consumer<Data> consumer) {
        actions.add(consumer);
    }

    public void write() {
        for (Consumer<Data> c : actions) {
            c.accept(this);
        }
        for (String s : data) {
            System.out.println(s);
        }
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
