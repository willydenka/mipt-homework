package hw.oop;

import java.util.Random;

public class Cuckoo extends Bird {
    @Override
    void sing() {
        Random random = new Random();
        int tmp = random.nextInt(10)+1;
        for (int i = 0; i < tmp; i++) {
            System.out.println("Ку-ку");
        }

    }
}
