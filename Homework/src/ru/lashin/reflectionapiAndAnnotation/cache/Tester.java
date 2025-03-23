package ru.lashin.reflectionapiAndAnnotation.cache;

import java.util.ArrayList;

class Tester {
    public static void main(String[] args) {
        Z z = new Z("first");
        ArrayList<Bukva> proxy = (ArrayList<Bukva>) Cacher.cache(z);
        System.out.println(proxy.getFirst().cacheTest());
        System.out.println("----");
        z.stringField = "second";
        System.out.println(proxy.getFirst().cacheTest());
        System.out.println("----");
        System.out.println(proxy.getFirst().cacheTest());
    }
}
