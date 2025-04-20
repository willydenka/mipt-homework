package ru.lashin.spring.beans;

public class Feedback {
    String text;
    int mark;

    public Feedback(int mark, String text) {
        this.mark = mark;
        this.text = text;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }
}
