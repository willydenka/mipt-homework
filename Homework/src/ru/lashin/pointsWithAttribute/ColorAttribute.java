package ru.lashin.pointsWithAttribute;

public class ColorAttribute extends Attribute {

    public ColorAttribute(Object value) {
        super("цвет: ", value);
    }

    @Override
    public String getValue() {
        return (String) super.getValue();
    }

}
