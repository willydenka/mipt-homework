package hw.oop;
// 1.5.1
public class Gun {
    private int cartridges;
    private final int capacity;

    public Gun(int capacity, int cartridges) {
        if (capacity >= 0 && cartridges <= capacity) {
            this.capacity = capacity;
            this.cartridges = cartridges;
        } else throw new IllegalArgumentException(
                "Вместимость магазина не может быть меньше 0 патронов," +
                        "а зарядить магазин нельзя количеством, превышающим вместимость");
    }

    public boolean isCharged() {
        return this.cartridges != 0;
    }

    public int getCartridges() {
        return this.cartridges;
    }

    public int getCapacity() {
        return capacity;
    }

    public int recharge(int cartridges) {
        if (cartridges < 0)
            throw new IllegalArgumentException("Перадано неверное количество патронов на перезарядку");
        if (this.cartridges == capacity)
            // Перезарядка не требуется
            return cartridges;
        int temp = capacity - (this.cartridges + cartridges);
        if (temp >= 0)
            return 0;
        return Math.abs(temp);
    }

    public int discharge() {
        int tmp = this.cartridges;
        this.cartridges = 0;
        return tmp;
    }

    public void shot() {
        if (cartridges > 0) {
            System.out.println("Бах");
            cartridges--;
        }
        else
            System.out.println("Клац");
    }
}