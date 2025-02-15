package ru.lashin.basic;

import java.util.ArrayList;
import java.util.Objects;
/**
 * Если необходимо представить дробь как отрицательное значение, то знак минус
 * указывается в числителе. Отрицательное значение в знаменателе приведет к исключению.
 */
public final class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    public static class Builder {
        private static final Builder builder = new Builder();
        private static final ArrayList<Fraction> cache = new ArrayList<>();
        private int numerator;
        private int denominator;

        private Builder() {}

        public static Builder values(int numerator, int denominator) {
            if (denominator<=0) exception();
            builder.numerator = numerator;
            builder.denominator = denominator;
            return builder;
        }
        public Fraction build() {
            Fraction fraction = new Fraction(builder.numerator, builder.denominator);
            int idx = cache.indexOf(fraction);
            if (idx != -1) return cache.get(idx);
            cache.add(fraction);
            return fraction;
        }
    }

    private Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction sum(int num) {
        return new Fraction(denominator * num + numerator, denominator);
    }
    public Fraction sum(Fraction anotherFraction) {
        if (denominator == anotherFraction.denominator)
            return new Fraction(numerator + anotherFraction.numerator, denominator);
        else {
            int firstNum, secondNum;
            int denom;
            denom = denominator * anotherFraction.denominator;
            firstNum = denom / denominator * numerator;
            secondNum = denom / anotherFraction.denominator * anotherFraction.numerator;
            return new Fraction(firstNum + secondNum, denom);
        }
    }

    public Fraction minus(int num) {
        return new Fraction(numerator - denominator * num, denominator);
    }
    public Fraction minus(Fraction anotherFraction) {
        if (denominator == anotherFraction.denominator)
            return new Fraction(numerator - anotherFraction.numerator, denominator);
        else {
            int firstNum, secondNum;
            int denom;
            denom = denominator * anotherFraction.denominator;
            firstNum = denom / denominator * numerator;
            secondNum = denom / anotherFraction.denominator * anotherFraction.numerator;
            return new Fraction(firstNum - secondNum, denom);
        }
    }

    public Fraction multiply(int num) {
        return new Fraction(numerator * num, denominator);
    }
    public Fraction multiply(Fraction anotherFraction) {
        return new Fraction(numerator * anotherFraction.numerator,
                denominator * anotherFraction.denominator);
    }

    public Fraction divide(int num) {
        if (num == 0)
            throw exception();
        return new Fraction(numerator, denominator * num);
    }
    public Fraction divide(Fraction anotherFraction) {
        if (anotherFraction.numerator == 0)
            throw exception();
        return new Fraction(numerator * anotherFraction.denominator,
                denominator * anotherFraction.numerator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Служебный метод для исключений
    private static IllegalArgumentException exception() {
        throw new IllegalArgumentException("Деление на ноль или некорректное значение");
    }

    @Override
    public int intValue() {
        return numerator/denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator/denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator/denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator/denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}