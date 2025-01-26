package ru.lashin.main;
import ru.lashin.basic.Fraction;
import ru.lashin.basic.Student;
import ru.lashin.geometry.Point;
import ru.lashin.methods.Methods;
import java.math.BigInteger;



public class Main {
    public static void main(String[] args) {

        // 3.1.3
        Methods.calculate(7,
                new Fraction(11, 3), new BigInteger("123456789123456789"));

        // 3.1.4
       // System.out.println(Methods.MyPow(args[0], args[1]));

        // 3.1.5
        Point point = new Point(2,2);
        java.awt.Point point2 = new java.awt.Point();

        System.out.println(Methods.concatenate("2", "d", "1"));

        Methods.testConvert();

    }
}
