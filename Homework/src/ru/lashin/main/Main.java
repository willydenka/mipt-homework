package ru.lashin.main;
import ru.lashin.basic.Fraction;
import ru.lashin.basic.Student;
import ru.lashin.geometry.Point;
import ru.lashin.methods.Methods;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;
import java.util.function.Function;


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

        // start 6.3.1
        ArrayList<String> listStrings = new ArrayList<>();
        listStrings.add("qwerty");
        listStrings.add("zx");
        listStrings.add("asdf");
        ArrayList<Integer> listNums = new ArrayList<>();
        listNums.add(-1);
        listNums.add(5);
        listNums.add(-7);
        ArrayList<int[]> listArrays = new ArrayList<>();
        listArrays.add(new int[]{1,800,-6,15});
        listArrays.add(new int[]{50,8,600,15});

        System.out.println(Methods.transformList(listStrings, t -> t.length()));

        System.out.println(Methods.transformList(listNums, t -> Math.abs(t)));

        System.out.println(Methods.transformList(listArrays, t -> {
            int max = t[0];
            for (int current : t) {
                if (current > max) max = current;
            }
            return max;
        }));
        // end 6.3.1
        // start 6.3.2
        System.out.println(Methods.filter(listStrings, t -> t.length()<3));
        System.out.println(Methods.filter(listNums, t -> t>0));
        ArrayList<int[]> res = Methods.filter(listArrays, t -> {
            for (int num : t) {
                if (num > 0) return false;
            }
            return true;
        });
        for (int[] arr : res) System.out.println(Arrays.toString(arr));
        // end 6.3.2
        // start 6.3.3
        System.out.println(Methods.reduction(listStrings, (a, b) -> a+b, "Дефолтное значение"));

        System.out.println(Methods.reduction(listNums, Integer::sum, -1));

        ArrayList<ArrayList<?>> listOfLists = new ArrayList<>();
        listOfLists.add(listNums);
        listOfLists.add(listStrings);
        int result = Methods.reduction(Methods.transformList(listOfLists, ArrayList::size), Integer::sum, -1);
        // end 6.3.3
        // start 6.3.4



    }
}
