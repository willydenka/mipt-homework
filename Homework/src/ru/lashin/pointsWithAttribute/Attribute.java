package ru.lashin.pointsWithAttribute;

public abstract class Attribute {
    private final String name;
    private Object value;

    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UniversalPoint{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
