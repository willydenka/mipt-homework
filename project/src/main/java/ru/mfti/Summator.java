package ru.mfti;

import java.util.Stack;

public class Summator {
    private static Stack<Double> numbers = new Stack<>(); // Создаем стэк для чисел
    private static Stack<Character> operators = new Stack<>(); // Создаем стэк для операторов
    // Почему стэк, потому что работает по принципу последним пришел, последним вышел
    // Поможет записать числа в правильном порядке

    // Главный метод
    public static double calculation(String expression) {
        for (int i = 0; i < expression.length(); i++) { // Проходимся по каждому символу
            char currentChar = expression.charAt(i); // Берем символ
            // Если текущий символ - цифра или текущий символ показывает, что число вначале выраж. или перед скобкой
            // или оно в принципе отрицательное, то
            if (Character.isDigit(currentChar) || currentChar == '-' &&
                    (i==0 || expression.charAt(i-1) == '(' || isOperator(expression.charAt(i-1)))) {
                StringBuilder number = new StringBuilder(); // Для оптимизированного временного хранения числа создаем билдер
                number.append(currentChar); // Добавляем в билдер текщий символ
                i++; // Идем к следующиму символу
                // Здесь перебираю все число с учетом дробной части.
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) { // Проходимся по цифрам, пока не наткнемся на что-то отличное от цифры
                    number.append(expression.charAt(i)); // Сохраняем цифры в правильном порядке благодаря стрингбилдеру
                    // Можно и обычную строку, но так, наверное, будет не ошенно оптимизировано =)
                    i++; // Идем к следующей цифре (или точке)
                }
                i--; // Так как вышли из цикла, скорее всего наткнулись на оператор
                // поэтому чтобы в следующем цикле его обработать, откидываем i назад
                double num = Double.parseDouble(number.toString()); // Парсим в дабл то, что собрал билдер
                numbers.push(num); // Закидываем готовое число в стэк
            }
            else if (currentChar == '(') { // Если нам попалась скобка
                operators.push(currentChar); // Закидываем ее в стэк операторов
            }
            else if (currentChar == ')') { // Если попалась скобка, то
                while (!operators.isEmpty() && operators.peek() != '(') // Проверяем что стэк не пустой и последний элемент его - не открывающая скобка
                    refreshStack(); // Берем последний оператор из стэка операторов и два числа из стэка чисел. Делаем операцию. Сохраняем новое значение в стэек чисел
                operators.pop(); // А сам этот оператор удалям.
            }
            else if (isOperator(currentChar)) { // Если попался арифметичский оператор
                // При этои стэк операторов не пустой и приоритет оператора в стэке больше или равен текущему оператору
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(currentChar))
                    refreshStack(); // Берем последний оператор из стэка операторов и два числа из стэка чисел. Делаем операцию. Сохраняем новое значение
                operators.push(currentChar); // Если стэк был пустой или приоритет текущего оператора больше, то помещаем этот оператор в стэк
            }
        }
        while (!operators.isEmpty()) // Когда все приоритетные операции выполнятся, в стеках останется все остальное
            refreshStack(); // Присуммируем все остальное к приоритетным операция
        return numbers.pop(); // Вытащим из стека результат и вернем его из метода
    }

    // Вспомогательный метод для выполнения операции над числами
    public static double applyOperator(double firstNum, double secondNum, char operator) {
        if (operator == '*') return firstNum * secondNum;
        if (operator == '/') {
            if (secondNum == 0) throw new ArithmeticException("Деление на ноль запрещено");
            return firstNum / secondNum;
        }
        if (operator == '+') return firstNum + secondNum;
        if (operator == '-') return firstNum - secondNum;
        throw new IllegalArgumentException("Неизвестный оператор");
    }

    // Тут мы устанавливаем приоритет операций умножения/деления над сложением/вычитанием
    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return -1;
    }
    // Тут мы обновляем стэки
    public static void refreshStack() {
        double b = numbers.pop();
        double a = numbers.pop();
        char op = operators.pop();
        numbers.push(applyOperator(a, b, op));
    }

    // Определяем, оператор ли
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


}
