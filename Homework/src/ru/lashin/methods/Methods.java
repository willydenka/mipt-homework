package ru.lashin.methods;
import ru.lashin.basic.Bird;
import ru.lashin.basic.Student;
import ru.lashin.geometry.Point;
import ru.lashin.geometry.Polyline;
import ru.lashin.geometry.Shape;
import ru.lashin.myExceptions.Connection;
import ru.lashin.myExceptions.LossOfConnectionException;
import ru.lashin.myExceptions.MarkException;
import java.util.*;
import java.util.Random;
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
        String info = "Оценки не добавились никому";
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
                count = 0;
                break;
            }
        }
        if (count > 0) info = "Все оценки записаны";
        return info;
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
}