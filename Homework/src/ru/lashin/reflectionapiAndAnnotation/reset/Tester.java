package ru.lashin.reflectionapiAndAnnotation.reset;

class Tester {
    public static void main(String[] args) throws Exception {
        Context context = new Context();
        context.setBean(String.class, "hello");
        context.setBean(int.class, 42);
        context.setBean(B.class, null);
        context.setBean(Object.class, new Object());
        B b = new B();
        Reset.reset(context, b);
        System.out.println(b);
    }
}
