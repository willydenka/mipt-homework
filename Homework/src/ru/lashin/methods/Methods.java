package ru.lashin.methods;
import ru.lashin.basic.*;
import ru.lashin.generics.Box;
import ru.lashin.generics.LazyStorage;
import ru.lashin.generics.Storage;
import ru.lashin.geometry.*;
import ru.lashin.myExceptions.LossOfConnectionException;
import ru.lashin.myExceptions.MarkException;
import java.util.*;
import java.util.Random;
import java.util.function.*;

import static java.lang.Math.*;
import static java.lang.Integer.parseInt;

public class Methods {

    // 2.3.1
    public static double calculate(Number... numbers) {
        double res = 0.0;
        for (Number number : numbers)
            res += number.doubleValue();
        return res;
    }

    // 2.3.2
    static void sing(Bird... birds) {
        for (Bird bird : birds) {
            if (bird != null) bird.sing();
        }
    }

    // 2.3.3
    static double square(Shape... shapes) {
        for (Shape shape : shapes)
            if (shape != null) return shape.area();
        return 0;
    }

    // 2.3.4
    static void cats(Meowble... meowbles) {
        for (Meowble meowble : meowbles)
            if (meowble != null) meowble.meow();
    }

    // 2.3.5
    static double length(Lengthable... lengthables) {
        for (Lengthable lengthable : lengthables)
            if (lengthable != null) return lengthable.length();
        return 0;
    }

    // 2.3.7
    static Polyline sumPolylines(Polylinable... polylinables) {
        ArrayList<Point> points = new ArrayList<>();
        for (Polylinable polylinable : polylinables) {
            if (polylinable != null) points.addAll(polylinable.getPolyline().getPoints());
        }
        return new Polyline(points.toArray(new Point[0]));
    }

    // 3.1.4
    public static int MyPow(String x, String y) {
        return (int) pow(parseInt(x), parseInt(y)); // Короткие имена
    }

    // 4.2.1
    public static void connect() {
        try (Connection connection = new Connection("ermakov.edu")) {
            for (int i = 0; i < 10; i++) {
                System.out.println(connection.getData());
            }
        } catch (LossOfConnectionException e) {
            System.out.println(e.getMessage());
        }
    }

    // 4.2.2
    public static double concatenate(String... strings) {
        ArrayList<Double> numbers = new ArrayList<>();
        for (String str : strings) {
            try {
                numbers.add(Double.parseDouble(str));
            } catch (NumberFormatException e) {} // Игнорируем
        }

        if (numbers.isEmpty()) return 0;
        double res = numbers.getFirst();
        numbers.removeFirst();
        for (double num : numbers) {
            if (num == 0) throw new ArithmeticException();
            res/=num;
        }
        return res;
    }

    // 4.2.3
    public static String addMark(Student... students) {
        Random random = new Random();
        int mark = random.nextInt(10)+1;
        int count = 0;
        for (Student student : students) {
            try {
                student.addMark(mark);
                count++;
            } catch (MarkException e) {
                for (int i = 0; i < count; i++)
                    students[i].deleteLastMark();
                throw new MarkException("Оценки не добавились никому");
            }
        }
        return "Оценки записаны";
    }

    // 4.2.4
    public static List<Student> convert(List<String> constructorArgs, List<String> addArgs) {
        return new ArrayList<>();
    }
    public static void testConvert() {
        List<String> constructorArgs = List.of("Параметры для конструктора");
        List<String> methodsArgs  = List.of("Параметры для метода");
        try {
            System.out.println(convert(constructorArgs, methodsArgs));
        } catch (MarkException e) {
            try {
                System.out.println(convert(constructorArgs, new ArrayList<>()));
            } catch (MarkException exception) {
                System.out.println("Студента " + exception.getMessage() + " создать невозмжно");
            }
        }
    }

    // 6.2.1
    public static void moveLine(Line<? extends Point> line) {
        int x = line.getStartPoint().x;
        x = x>=0 ? x+10 : x-10;
        line.getStartPoint().x = x;
    }

    // 6.2.2
    public static double findMax(List<Box<? extends Number>> boxes) {
        double max = (double) boxes.getFirst().getValue();
        for (int i = 1; i < boxes.size(); i++) {
            double current = (double)boxes.get(i).getValue();
            if (current > max)
                max = current;
        }
        return max;
    }

    // 6.2.3
    public static void startCountdown(Box<? super Point3d> box) {
        box.setValue(new Point3d(1,2,3));
    }

    // 6.2.4
    public static void fillList(List<? super Integer> list) {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

    // 6.3.1
    /*
    Разработайте такой метод, который будет принимать список значений типа T,
    и объект имеющий единственный метод apply. Данный метод надо применить к каждому элементу списка,
    и вернуть новый список значений типа P, при этом типы T и P могут совпадать, а могут не совпадать.
     */
    public static <T, P> ArrayList<P> map(List<T> list, Function<T, P> function) {
        ArrayList<P> result = new ArrayList<>();
        for (T t : list) result.add(function.apply(t));
        return result;
    }

    // 6.3.2
    /*
    Разработайте такой метод, который будет принимать список значений типа T и
    объект имеющий единственный метод test (принимает T и возвращает boolean).
    Верните новый список типа T, из которого удалены все значения не прошедшие проверку условием.
     */
    public static <T> ArrayList<T> filter(List<T> list, Predicate<T> predicate) {
        ArrayList<T> result = new ArrayList<>();
        for (T t : list)
            if (predicate.test(t)) result.add(t);
        return result;
    }

    // 6.3.3
    /*
    Разработайте такой метод, который будет принимать список значений типа T
    и способ с помощью которого список значений можно свести к
    одному значению типа T, которое и возвращается из метода.
     */
    public static <T> Storage<T> reduce(List<T> list, BinaryOperator<T> binaryOperator) {
        T result = list.getFirst();
        for (T t : list)
            result = binaryOperator.apply(result, t);
        return  Storage.of(result);
    }

    // 6.3.4
    /*
    Разработайте такой метод, который будет возвращать коллекцию типа P со значениями типа T.
    Данный метод будет принимать:
    1.	Список исходных значений
    2.	Способ создания результирующей коллекции
    3.	Способ передачи значений исходного списка в результирующую коллекцию.
     */
    public static <R, T extends List<R>, P extends List<T>> P collect(
            List<R> list,
            Supplier<P> supplier,
            BiConsumer<R, P> consumer) {
        P result = supplier.get();
        for (R r : list)
            consumer.accept(r, result);
        return result;
    }

    // Задача про Storage
    public static LazyStorage<Integer> sum(int... nums) {
        if (nums == null) return LazyStorage.empty();
        int sum = 0;
        for (int num: nums) {
            sum+=num;
            System.out.println("counting");
        }
        return LazyStorage.of(sum);
    }
}