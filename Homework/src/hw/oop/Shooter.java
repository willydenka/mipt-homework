package hw.oop;

public class Shooter {
    private final String name;
    private Gun gun;

    public Shooter(String name) {
        this.name = name;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public String getName() {
        return name;
    }

    public Gun getGun() {
        return gun;
    }

    public void fire() {
        if (gun == null) {
            System.out.println("Не могу учавствовать в перестрелке");
            return;
        }
        gun.shot();
    }
}