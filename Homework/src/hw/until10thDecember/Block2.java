package hw.until10thDecember;

public class Block2 {

    // 2.1
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал только дробную часть числа х.
     */
    public static double fraction(double x) {
        return x%1;
        // Второй вариант: return x-(int)x;
    }

    // 2.2
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал результат сложения двух
    последних знаков числа х, предполагая,
    что знаков в числе не менее двух.
     */
    public static int sumLastNums(int x) {
        return (x%100/10) + (x%10);
    }

    // 2.3
     /*
    Метод принимает символ х, который представляет
    собой один из “0 1 2 3 4 5 6 7 8 9”.
    Необходимо реализовать метод таким образом,
    чтобы он преобразовывал символ в соответствующее число.
    */
    public static int charToNum(char x) {
        return x - '0';
    }

    // 2.4
    /*
    Необходимо реализовать метод таким образом,
    чтобы он принимал число x и возвращал true
    если оно положительное.
     */
    public static boolean isPositive(int x) {
        return x > 0;
    }

    // 2.5
    /*
    Необходимо реализовать метод таким образом,
    чтобы он принимал число x и возвращал true
    если оно двузначное.
     */
    public static boolean is2Digits(int x) {
        return (x>9 && x<100) || (x>-100 && x<-9);
    }

    // 2.6
    /*
    Необходимо реализовать метод таким образом,
    чтобы он принимал символ x и возвращал true
    если это большая буква в диапазоне от ‘A’ до ‘Z’.
     */
    public static boolean isUpperCase(char x) {
        return x>='A' && x<='Z';
    }

    // 2.7
    /*
    Метод принимает левую и правую границу (a и b)
    некоторого числового диапазона. Необходимо
    реализовать метод таким образом, чтобы он
    возвращал true, если num входит в указанный
    диапазон (включая границы).
     */
    public static boolean isInRange(int a, int b, int num) {
        return (num<=a && num>=b) || (num>=a && num<=b);
    }

    // 2.8
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал true если любое из
    принятых чисел делит другое нацело.
     */
    public static boolean isDivisor(int a, int b) {
        return a%b==0 || b%a==0;
    }

    // 2.9
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал true если все три
    полученных методом числа равны.
     */
    public static boolean isEqual(int a, int b, int c) {
        return a==b && a==c;
    }

    // 2.10
    /*
    Выполните с помощью метода последовательное
    сложение пяти чисел:
    5, 11, 123, 14, 1, и результат выведите на экран.
     */
    public static int lastNumSum(int a, int b) {
        return (a%10)+(b%10);
    }
    public static void main(String[] args) {
        System.out.println(
        lastNumSum(
                lastNumSum(
                    lastNumSum(
                        lastNumSum(5, 11),
                            123),
                        14),
                1)
        );
    }
}
