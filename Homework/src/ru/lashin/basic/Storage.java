package ru.lashin.basic;

public class Storage<T> {
    private final T t;
    private final T defaultValue;

    public Storage(T t, T defaultValue) {
        this.t = t;
        this.defaultValue = defaultValue;
    }

    public T getValue() {
        if (this.t == null) return defaultValue;
        return t;
    }
}

class Test {
    public static void main(String[] args) {
        Storage<Integer> integerStorage = new Storage<>(null, 0);
        test(integerStorage);
        Storage<Integer> integerStorage2 = new Storage<>(99, -1);
        test(integerStorage2);
        Storage<String> stringStorage = new Storage<>(null, "default");
        test(stringStorage);
        Storage<String> stringStorage2 = new Storage<>("hello", "hello world");
        test(stringStorage2);
    }

    public static void test(Storage<?> storage) {
        System.out.println(storage.getValue());
    }
}
