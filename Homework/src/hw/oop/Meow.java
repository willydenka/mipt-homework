package hw.oop;
// 2.3.4
public abstract class Meow {
    private final String name;
    
    public Meow(String name) {
        this.name = name;
    }
    
    abstract void meow();
    
    public String getName() {
        return name;
    }
}

interface Meowable {
    static void meow(Meow meow) {
        meow.meow();
    }
}
