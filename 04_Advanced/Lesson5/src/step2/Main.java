/**
 * Завдання 2. Напишіть програму, яка виводитиме всю інформацію про клас, користувач сам вибирає, який саме клас цікавить.
 */
package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        ClassInfo.check("Неіснуючий_Клас", true);
        ClassInfo.check("step2.SampleClass", true);

        String className = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("Введіть повну назву класу (пусто - вихід): ");
            try {
                className = reader.readLine();
                className = className.trim();
                if (!className.isEmpty()) ClassInfo.check(className, false);
            } catch (IOException e) {
                System.out.println("Повторіть введення.");
            }

        } while (!className.isEmpty());
    }
}