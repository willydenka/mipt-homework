package ru.lashin.basic;
// 1.5.1
public class Gun extends Weapon{
    protected final int capacity;

    public Gun(int capacity, int ammo) {
        super(ammo);
        if (capacity >= 0 && ammo <= capacity) {
            this.capacity = capacity;
        } else throw new IllegalArgumentException(
                "Вместимость магазина не может быть меньше 0 патронов," +
                        "а зарядить магазин нельзя количеством, превышающим вместимость");
    }

    public boolean isCharged() {
        return ammo() == 0;
    }


    public int getCapacity() {
        return capacity;
    }

    public int recharge(int ammo) {
        if (ammo < 0)
            throw new IllegalArgumentException("Перадано неверное количество патронов на перезарядку");
        if (ammo() == capacity)
            // Перезарядка не требуется
            return ammo;
        int temp = capacity - (ammo() + ammo);
        if (temp >= 0)
            return 0;
        return Math.abs(temp);
    }

    public int discharge() {
        int tmp = 0;
        while (!isCharged()) {
            getAmmo();
            tmp++;
        }
        return tmp;
    }

    public void shot() {
        if (ammo() > 0) {
            System.out.println("Бах");
            getAmmo();
        }
        else
            System.out.println("Клац");
    }
}