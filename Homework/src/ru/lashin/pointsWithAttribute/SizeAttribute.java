package ru.lashin.pointsWithAttribute;

public class SizeAttribute extends Attribute {

    public SizeAttribute(Object value) {
       super("размер: ", value);
    }

    @Override
    public String getValue() {
        return (String) super.getValue();
    }
}
