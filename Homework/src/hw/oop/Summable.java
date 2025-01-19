package hw.oop;
// 2.3.1
public interface Summable {
    static double calculate(Number... numbers) { // Статику, чтоб не создавать новый класс под это
        double res = 0.0;
        for (Number number : numbers)
            res += number.doubleValue();
        return res;
    }
}
