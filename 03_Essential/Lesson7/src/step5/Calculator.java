/* Завдання 5.
 Створіть клас Calculator. У тілі класу створіть чотири методи для арифметичних дій: (add – додавання, sub – віднімання, mul – множення, div – поділ).
 Метод поділу повинен перевірити поділ на нуль, якщо перевірка не проходить, згенерувати виняток.
 Користувач вводить значення, над якими хоче зробити операцію та вибрати саму операцію. У разі виникнення помилок повинні викидатися винятки.
 */
package step5;


import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidOperatorException extends Exception {
    public InvalidOperatorException() {
        super("Оператором може бути один з 4 символів {+, -, *, /}");
    }
}

public class Calculator {
    static final String msgTryAgain = " Повторіть введення.";
    static final String validOperators = "+-*/";
    char operator;
    private int p1, p2, res;

    public static void main(String[] args) {
        new Calculator().run();
    }

    public int add() {
        return this.p1 + this.p2;
    }

    public int sub() {
        return p1 - p2;
    }

    public int mul() {
        return p1 * p2;
    }

    public int div() {
        return p1 / p2;
    }

    public void GetParams() {
        while (true) try {
            System.out.print("Введіть перше число: ");
            this.p1 = new Scanner(System.in).nextInt();
            System.out.print("Введіть друге число: ");
            this.p2 = new Scanner(System.in).nextInt();
            System.out.print("Введіть один оператор {+, -, *, /}: ");
            this.operator = new Scanner(System.in).next().charAt(0);

            if (validOperators.indexOf(this.operator) == -1) throw new InvalidOperatorException();
            break;
        } catch (InvalidOperatorException e) {
            System.out.println(e.getMessage() + Calculator.msgTryAgain);
        } catch (InputMismatchException e) {
            System.out.println("Напевно ви ввели літери замість цифр." + Calculator.msgTryAgain);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Якась інша помилка." + Calculator.msgTryAgain);
        }
    }

    public int calculate() {
        return switch (this.operator) {
            case '+' -> add();
            case '-' -> sub();
            case '*' -> mul();
            case '/' -> div();
            default -> 0;
        };
    }

    public void print() {
        System.out.println("====================");
        System.out.printf("%d %c %d = %d\n", p1, operator, p2, res);
        System.out.println("====================");
    }

    public void run() {
        this.GetParams();
        try {
            this.res = calculate();
            print();
        } catch (ArithmeticException e) {
            System.out.println("Ділення на 0 (" + e.getMessage() + ")");
        }
    }
}