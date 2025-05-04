package ru.lashin.spring.beans.streamPlatform;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Data {
    private String pathFrom;
    private String pathTo;
    private List<String> lines;
    private final List<Consumer<List<String>>> actions;

    public Data(List<Consumer<List<String>>> actions) {
        this.actions = actions;
    }

    public String getPathFrom() {
        return pathFrom;
    }

    public void setPathFrom(String pathFrom) {
        this.pathFrom = pathFrom;
    }

    public String getPathTo() {
        return pathTo;
    }

    public void setPathTo(String pathTo) {
        this.pathTo = pathTo;
    }

    public void addAction(Consumer<List<String>> action) {
        actions.add(action);
    }

    public void executeActions() {
        try {
            read();
        } catch (IOException e) {
            throw new IllegalArgumentException("Файл для чтения или записи не найден");
        }
        format();
        try {
            write();
        } catch (IOException e) {
            throw new IllegalArgumentException("Файл для чтения или записи не найден");
        }
    }

    private void read() throws IOException {
        lines = Files.readAllLines(Path.of(pathFrom)); // Читаем
    }

    private void format() {
        actions.forEach(el -> el.accept(lines));
    }

    private void write() throws IOException {
        Files.write(Path.of(pathTo), lines);
    }



}
