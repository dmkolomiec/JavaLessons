/*
Завдання 2. Потрібно: Описати клас з ім'ям Worker, що містить такі поля:
  прізвище та ініціали працівника;
  назва посади;
  рік надходження на роботу.
Написати програму, яка виконує такі дії:
  введення з клавіатури даних до масиву, що складається з п'яти елементів типу Worker (записи мають бути впорядковані за абеткою);
  якщо значення року введено не у відповідному форматі, видає виняток.
  виведення на екран прізвища працівника, стаж роботи якого перевищує введене значення.
 */
package step2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidEmplymentYearException extends Exception {
    public InvalidEmplymentYearException() {
        super("Рік прийому повнен бути в діапазоні [1900.." + Worker.currentYear + "]");
    }
}

class EmptyFieldException extends Exception {
    public EmptyFieldException() {
        super("Реквізит не може бути пустим");
    }
}

class arSizeException extends Exception {
    public arSizeException() {
        super("Невдалий розмір масиву");
    }
}

class InvalidExperienceException extends Exception {
    public InvalidExperienceException() {
        super("Стаж повинен бути в діапазоні [0..100]");
    }
}

public class Worker {
    static final int currentYear = LocalDate.now().getYear();
    static final String msgUnknownError = " Невідома помилка.";
    static final String msgTryAgain = " Повторіть введення.";
    private String initials, surname, position;
    private int employmentYear;

    public static void printHead() {
        System.out.println("    Прізвище І.П.       Посада     Рік");
        System.out.println("==================== ============ ====");
    }

    public static void main(String[] args) {
        Worker[] wa;     // масив працівників
        int arSize;      // Розмір масиву
        int experience;  // Cтаж роботи

        // Розмір масиву
        while (true) try {
            System.out.print("Розмір масиву [2..5]: ");
            arSize = new Scanner(System.in).nextInt();

            if (arSize < 2 || arSize > 5) throw new arSizeException();
            break;
        } catch (arSizeException e) {
            System.out.println(e.getMessage() + Worker.msgTryAgain);
        } catch (Exception e) {
            System.out.println(e.getMessage() + Worker.msgUnknownError + Worker.msgTryAgain);
        }

        // Стаж роботи
        while (true) try {
            System.out.print("Введіть мінімальний стаж роботи (років): ");
            experience = new Scanner(System.in).nextInt();
            if (experience < 0 || experience > 100) throw new InvalidExperienceException();
            break;
        } catch (InvalidExperienceException e) {
            System.out.println(e.getMessage() + Worker.msgTryAgain);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage() + Worker.msgUnknownError + Worker.msgTryAgain);
        }

        wa = new Worker[arSize];

        for (int i = 0; i < wa.length; i++) {
            wa[i] = new Worker();
            wa[i].manualInput(i + 1);
        }
        Arrays.sort(wa, Comparator.comparing(Worker::getFullName));

        Worker.printHead();
        for (Worker w : wa)
            w.print();

        System.out.printf("\nПрацівники зі стажем більше %d років (станом на %d р.)\n", experience, Worker.currentYear);
        Worker.printHead();
        for (Worker w : wa)
            if (Worker.currentYear - experience > w.getEmploymentYear()) w.print();
    }

    public int getEmploymentYear() {
        return employmentYear;
    }

    public String getFullName() {
        return this.surname + " " + this.initials;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-12s %4d", this.getFullName(), this.position, this.employmentYear);
    }

    public void print() {
        System.out.println(this);
    }

    public void manualInput(int serNum) {

        while (true) try {
            System.out.println("---------- Працівник № " + serNum + " ----------");
            System.out.print("Введіть прізвище: ");
            this.surname = new Scanner(System.in).nextLine();

            System.out.print("Введіть ініціали: ");
            this.initials = new Scanner(System.in).nextLine();

            System.out.print("Введіть посаду: ");
            this.position = new Scanner(System.in).nextLine();

            if (this.surname.isEmpty() || this.initials.isEmpty() || this.position.isEmpty())
                throw new EmptyFieldException();
            break;
        } catch (EmptyFieldException e) {
            System.out.println(e.getMessage());
        }

        while (true) try {
            System.out.print("Введіть рік: ");
            this.employmentYear = new Scanner(System.in).nextInt();

            if (this.employmentYear < 1900 || this.employmentYear > Worker.currentYear)
                throw new InvalidEmplymentYearException();
            break;
        } catch (InvalidEmplymentYearException e) {
            System.out.println(e.getMessage() + Worker.msgTryAgain);
        } catch (Exception e) {
            System.out.println(e.getMessage() + Worker.msgUnknownError + Worker.msgTryAgain);
        }
    }
}
