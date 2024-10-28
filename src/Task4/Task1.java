package Task4;

import java.util.*;

public class Task1 {

    // Метод для проверки приоритета оператора
    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
                return 2;
            default:
                return -1;
        }
    }

    // Метод для проверки, является ли символ оператором
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*';
    }

    // Метод для проверки, является ли символ скобкой
    public static boolean isBracket(char ch) {
        return ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']';
    }

    // Метод для добавления умножения между скобками, если нет оператора
    public static String addImplicitMultiplication(String expression) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            // Добавляем текущий символ
            result.append(current);

            // Если текущий символ - закрывающая скобка, а следующий - открывающая скобка или число, добавляем '*'
            if (i < expression.length() - 1) {
                char next = expression.charAt(i + 1);

                if ((current == ')' || current == '}' || current == ']') &&
                    (next == '(' || next == '{' || next == '[' || Character.isDigit(next))) {
                    result.append('*');
                }

                // Если текущий символ - число, а следующий - открывающая скобка, добавляем '*'
                if (Character.isDigit(current) &&
                    (next == '(' || next == '{' || next == '[')) {
                    result.append('*');
                }
            }
        }
        return result.toString();
    }

    // Метод для преобразования инфиксного выражения в постфиксное
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Если символ является числом, добавляем его в результат
            if (Character.isDigit(c)) {
                result.append(c);
            }
            // Если символ - открывающая скобка, помещаем её в стек
            else if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Если символ - закрывающая скобка, извлекаем из стека до открывающей скобки
            else if (c == ')' || c == ']' || c == '}') {
                char openingBracket = (c == ')') ? '(' : (c == ']') ? '[' : '{';
                while (!stack.isEmpty() && stack.peek() != openingBracket) {
                    result.append(stack.pop());
                }
                stack.pop(); // Удаляем соответствующую открывающую скобку
            }
            // Если символ - оператор
            else if (isOperator(c)) {
                while (!stack.isEmpty() && !isBracket(stack.peek()) &&
                        getPrecedence(stack.peek()) >= getPrecedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Извлекаем все оставшиеся операторы из стека
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Метод для вычисления постфиксного выражения
    public static int evaluatePostfix(String expression) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Если символ - число, помещаем его в стек
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // Преобразуем символ в число
            }
            // Если символ - оператор, извлекаем два операнда и выполняем операцию
            else if (isOperator(c)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                }
            }
        }

        // Последний элемент в стеке - результат
        return stack.pop();
    }

    // Метод для подсчета количества символов в строке
    public static int count(String line, char chr) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == chr) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите математическое выражение: ");
        String expr = s.nextLine();

        // Проверка на соответствие количества открывающих и закрывающих скобок
        if ((count(expr, '(') == count(expr, ')')) &&
                (count(expr, '[') == count(expr, ']')) &&
                (count(expr, '{') == count(expr, '}'))) {

            // Добавляем умножение, если оно опущено между скобками
            expr = addImplicitMultiplication(expr);

            // Преобразование инфиксного выражения в постфиксное
            String postfix = infixToPostfix(expr);

            // Вычисление постфиксного выражения
            int result = evaluatePostfix(postfix);
            System.out.println("Результат выражения: " + result);

        } else {
            System.out.println("Выражение введено неверно: неправильное количество скобок.");
        }
    }
}
