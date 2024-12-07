package hw.until10thDecember;

import java.util.Scanner;

public class Block4 {

    // 4.1
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал строку, в которой будут
    записаны все числа от 0 до x (включительно).
     */
    public static String listNums(int x) {
        String str= "";
        for (int i=0; i<=x; i++)
            str+=i;
        return str;
    }

    // 4.2
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал строку, в которой будут
    записаны все числа от x до 0 (включительно).
     */
    public static String reverseListNums(int x) {
        String str = "";
        for (int i=x; i>=0; i--)
            str+=i;
        return str;
    }

    // 4.3
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал строку, в которой будут
    записаны все четные числа от 0 до x (включительно).
     */
    public static String chet(int x) {
        String str = "";
        for (int i=0; i<=x; i+=2)
            str+=i;

        return str;
    }

    // 4.4
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал результат возведения x в степень y.
     */
    public static int pow(int x, int y) {
        int pow = 1;
        for (int i=0; i<y; i++)
            pow*=x;
        return pow;
    }

    // 4.5
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал количество знаков в числе x.
     */
    public static int numLen(long x) {
        long temp = x;
        int len = 0;
        while (temp!=0) {
            len++;
            temp/=10;
        }
        return len;
    }

    // 4.6
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал true, если все знаки
    числа одинаковы, и false в ином случае.
     */
    public static boolean equalNum(int x) {
        int firstDigit = x%10;
        int nextNum = x/10;
        while (nextNum>0) {
            if (firstDigit != nextNum%10)
                return false;
            nextNum/=10;
        }
        return true;
    }

    // 4.7
    /*
    Необходимо реализовать метод таким образом,
    чтобы он выводил на экран квадрат из символов
    ‘*’ размером х, у которого х символов в ряд и
    х символов в высоту.
     */
    public static void square(int x) {
        for (int i=0; i<x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 4.8
    /*
    Необходимо реализовать метод таким образом,
    чтобы он выводил на экран треугольник из
    символов ‘*’ у которого х символов в высоту,
    а количество символов в ряду совпадает с
    номером строки.
     */
    public static void leftTriangle(int x) {
        for (int i=1; i<=x; i++) {
            for (int j=0; j<i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    // 4.9
    /*
    Необходимо реализовать метод таким образом,
    чтобы он выводил на экран треугольник из
    символов ‘*’ у которого х символов в высоту,
    а количество символов в ряду совпадает с
    номером строки, при этом треугольник выровнен
    по правому краю.
     */
    public static void rightTriangle(int x) {
        for (int i=0; i<x; i++) {
            for (int j=i; j<x-1; j++)
                System.out.print(" ");
            for (int j=0; j<i+1; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    // 4.10
    /*
    Метод считывает с консоли введенное
    пользователем число и выводит, угадал
    ли пользователь то, что было загадано,
    или нет. Перепишите этот метод таким
    образом, чтобы он запускался до тех пор,
    пока пользователь не угадает число.
    После этого выведите на экран количество
    попыток, которое потребовалось
    пользователю, чтобы угадать число. 
     */
    public static void guessGame() {
        int randomNum = 3;
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            System.out.print("What number am I thinking (0 to 9)?: ");
            int x = sc.nextInt();
            count++;
            if (x==randomNum) {
                System.out.println("Yes, it`s " + randomNum);
                System.out.println("Число попыток: " + count);
                break;
            }
            else
                System.out.println("No, try again");
        } while (true);
    }
}
