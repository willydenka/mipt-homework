package hw.oop;
// 1.5.2
public class Cat extends Meow {

    public Cat(String name) {
        super(name);
    }
    @Override
    public void meow() {
        System.out.println(getName() + ": мяу!");
    }

    public void meow(int n) {
        String res = "мяу";
        if (n >= 1) {
            for (int i = 0; i < n-1; i++) {
                res += "-мяу";
            }
            System.out.println(getName() + ": " + res);
        }
        else throw new IllegalArgumentException("Кот не может мяукать меньше одного раза");
    }

    @Override
    public String toString() {
        return "Кот: " + getName();
    }
}

