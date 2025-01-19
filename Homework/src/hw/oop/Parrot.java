package hw.oop;

import java.util.Random;

public class Parrot extends Bird {
    private final String text;

    public Parrot(String text) {
        this.text = text;
    }
    @Override
    void sing() {
        Random random = new Random();
        int n = random.nextInt(text.length())+1;
        for (int i = 0; i < n; i++) {
            System.out.println(text.charAt(i));
        }
    }
}
