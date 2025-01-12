package hw.oop;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator <= 0)
            throw exception();
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
    private IllegalArgumentException exception() {
        throw new IllegalArgumentException("Деление на ноль или некорректное значение");
    }
}
