/* Завдання 3.  Описати клас з іменем Price, що містить такі поля:
  назву товару;
  назву магазину, в якому продається товар;
  вартість товару у гривнях.
 Написати програму, яка виконує такі дії:
  введення з клавіатури даних до масиву, що складається з двох елементів типу Price (записи мають бути впорядковані в алфавітному порядку за назвами магазинів);
  виведення на екран інформації про товари, що продаються в магазині, назва якого введена з клавіатури (якщо такого магазину немає, вивести виняток).
*/
package step3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class EmptyFieldException extends Exception {
    public EmptyFieldException() {
        super("Поле не може бути пустим");
    }
}

class NotFoundAnyProductException extends Exception {
    public NotFoundAnyProductException() {
        super("Не знайдно жодного товару");
    }
}

public class Price {
    static final String msgUnknownError = " Невідома помилка.";
    static final String msgTryAgain = " Повторіть введення.";
    private String name, provider;
    private float price;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String searchProvider;
        Price[] pa = new Price[2];
        for (int i = 0; i < pa.length; i++) {
            pa[i] = new Price();
            pa[i].manualInput(i + 1);
        }

        while (true) try {
            System.out.print("Введіть назву продавця, товари якго потрібно знайти: ");
            searchProvider = input.nextLine();

            if (searchProvider.isEmpty()) throw new EmptyFieldException();
            break;
        } catch (EmptyFieldException e) {
            System.out.println(e.getMessage() + Price.msgTryAgain);
        } catch (Exception e) {
            System.out.println(e.getMessage() + Price.msgUnknownError + Price.msgTryAgain);
        }

        Arrays.sort(pa, Comparator.comparing(Price::getProvider));

        printHead();
        for (Price p : pa)
            p.print();

        try {
            System.out.printf("\nТовари продавця '%s'\n", searchProvider);
            boolean foundSomething = false;
            for (Price p : pa)
                if (p.getProvider().equals(searchProvider)) {
                    if (!foundSomething) printHead();
                    p.print();
                    foundSomething = true;
                }
            if (!foundSomething) throw new NotFoundAnyProductException();
        } catch (NotFoundAnyProductException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printHead() {
        System.out.println("     Товар        Ціна      Продавець");
        System.out.println("=============== ======== ===============");
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return String.format("%-15s %8.2f %-15s", this.name, this.price, this.provider);
    }

    public void print() {
        System.out.println(this);
    }

    public void manualInput(int serNum) {

        while (true)

            try {
                System.out.println("---------- Товар  № " + serNum + " ----------");
                System.out.print("Введіть назву товару: ");
                this.name = new Scanner(System.in).nextLine();

                System.out.print("Введіть назву продавця: ");
                this.provider = new Scanner(System.in).nextLine();

                if (this.name.isEmpty() || this.provider.isEmpty()) throw new EmptyFieldException();

                System.out.print("Введіть ціну: ");
                this.price = new Scanner(System.in).nextFloat();

                break;
            } catch (EmptyFieldException e) {
                System.out.println(e.getMessage() + Price.msgTryAgain);
            } catch (Exception e) {
                System.out.println(e.getMessage() + Price.msgUnknownError + Price.msgTryAgain);
            }
    }
}
