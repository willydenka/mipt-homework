package hw.oop;
// 2.3.2
public abstract class Bird {
    abstract void sing();
}

interface Singable {
    static void sing(Bird bird) {
        bird.sing();
    }
}