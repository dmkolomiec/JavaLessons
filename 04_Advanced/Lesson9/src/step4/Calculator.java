package step4;

import java.util.InputMismatchException;
import java.util.Scanner;

interface ArithmeticOperation {
    double calculate(double p1, double p2, char operator);
}

class InvalidOperatorException extends Exception {
    public InvalidOperatorException() {
        super("Оператором може бути один з 4 символів {+, -, *, /}.");
    }
}

public class Calculator {
    static final String msgTryAgain = " Повторіть введення.";
    static final String validOperators = "+-*/";
    char operator;
    private double p1, p2, res;

    public boolean GetParams() {
        Scanner scanner = new Scanner(System.in);

        while (true) try {
            System.out.print("Введіть один оператор {+, -, *, /} (пусто - вихід): ");
            operator = scanner.nextLine().charAt(0);
            if (validOperators.indexOf(this.operator) == -1) throw new InvalidOperatorException();
            System.out.print("Введіть перше число: ");
            this.p1 = scanner.nextDouble();
            System.out.print("Введіть друге число: ");
            this.p2 = scanner.nextDouble();
            return true;

        } catch (InvalidOperatorException e) {
            System.out.println(e.getMessage() + Calculator.msgTryAgain);
        } catch (InputMismatchException e) {
            System.out.println("Напевно ви ввели літери замість цифр." + Calculator.msgTryAgain);
            scanner.nextLine(); // Щоб уникнути зациклювання
        } catch (StringIndexOutOfBoundsException e) {
            return false;  // Вихід
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Якась інша помилка." + Calculator.msgTryAgain);
        }
    }

    public void run() {
        while (GetParams()) {
            ArithmeticOperation op = (p1, p2, operator) -> switch (operator) {
                case '+' -> p1 + p2;
                case '-' -> p1 - p2;
                case '*' -> p1 * p2;
                case '/' -> p1 / p2;
                default -> 0;
            };

            res = op.calculate(p1, p2, operator);
            System.out.println("=======================");
            System.out.printf("%.2f %c %.2f = %.2f\n", p1, operator, p2, res);
            System.out.println("=======================");
        }
    }
}