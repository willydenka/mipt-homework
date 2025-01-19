package hw.oop;

public class AutomaticRifle extends Gun{

    private final int rateOfFire;

    public AutomaticRifle() { // Без параметров. Скорострельность 30, вместимость 30.
        this(30, 0, 30);
    }

    public AutomaticRifle(int ammoMax) { // С указанием максимального числа патронов. Скорострельность будет равна половине обоймы
        if (ammoMax <= 0) ammoMax = 10; // Дефолтное значение
        this(0, ammoMax, ammoMax/2);
    }

    public AutomaticRifle(int ammoMax, int rateOfFire) { // С указанием максимального количества патронов в обойме и скорострельности
        if (ammoMax <= 0) ammoMax = 10; // Дефолтное значение
        this(0, ammoMax, rateOfFire);
    }

    public AutomaticRifle(int capacity, int ammo, int rateOfFire) {
        super(capacity, ammo);
        if (rateOfFire <= 0)
            rateOfFire = 10; // Чтоб не кидать исключение, при неправильном значении пускай устанавивается значение по умолчанию 10
        this.rateOfFire = rateOfFire;
    }
    @Override
    public void shot() {
        shotNSeconds(rateOfFire);
    }
    // Умеет Стрелять N секунд, что приводит к количеству выстрелов равному N умноженное на скорострельность.
    public void shot(int seconds) {
        shotNSeconds(rateOfFire*seconds);
    }
    private void shotNSeconds(int rateOfFire) {
        for (int i = 0; i < rateOfFire; i++) {
            if (ammo() > 0) {
                System.out.println("Бах");
                getAmmo();
            } else {
                System.out.println("Клац");
                return;
            }
        }
    }
}
