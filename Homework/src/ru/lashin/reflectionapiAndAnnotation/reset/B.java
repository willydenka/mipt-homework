package ru.lashin.reflectionapiAndAnnotation.reset;

@Default(B.class)
class B {
    String s;
    int x;
    B b;
    Object obj;

    @Override
    public String toString() {
        return "B{" +
                "s='" + s + '\'' +
                ", x=" + x +
                ", b=" + b +
                ", obj=" + obj +
                '}';
    }
}
