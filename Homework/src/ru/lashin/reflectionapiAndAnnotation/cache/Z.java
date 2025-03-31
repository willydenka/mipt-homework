package ru.lashin.reflectionapiAndAnnotation.cache;

import java.util.Objects;

@Cache({"cacheTest"})
public class Z implements Bukva {
    String stringField;

    public Z(String stringField) {
        this.stringField = stringField;
    }

    @Override
    public int cacheTest() {
        System.out.println("original method");
        return 42;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Z z)) return false;
        return Objects.equals(stringField, z.stringField);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stringField);
    }
}
