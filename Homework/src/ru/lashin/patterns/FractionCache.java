package ru.lashin.patterns;

import ru.lashin.basic.Fraction;
import ru.lashin.basic.Fractionable;
import java.util.HashMap;
import java.util.Map;

public class FractionCache implements Fractionable {
    private final Fraction fraction;
    private final int hashFraction;
    private final Map<Integer, Object> cache = new HashMap<>();


    public FractionCache(Fraction fraction) {
        this.fraction = fraction;
        hashFraction = fraction.hashCode();
    }

    @Override
    public Fraction sum(int num) {
        if (cache.containsKey(hashFraction + num)) return (Fraction) cache.get(hashFraction +num);
        Fraction res = fraction.sum(num);
        cache.put(hashFraction +num, res);
        return res;
    }

    @Override
    public int intValue() {
        if (cache.containsKey(hashFraction)) return (int) cache.get(hashFraction);
        int value = fraction.intValue();
        cache.put(hashFraction, value);
        return value;
    }
}

class Test2 {
    public static void main(String[] args) {
        Fraction fraction = Fraction.Builder.getBuilder().build(1,1);
        FractionCache fractionCache = new FractionCache(fraction);
        test(fractionCache);
    }
    static void test(Fractionable fractionable) {
        System.out.println(fractionable.sum(5));
        System.out.println(fractionable.sum(4));
        System.out.println(fractionable.sum(4));

        System.out.println(fractionable.intValue());
        System.out.println(fractionable.intValue());
        System.out.println(fractionable.intValue());
    }
}