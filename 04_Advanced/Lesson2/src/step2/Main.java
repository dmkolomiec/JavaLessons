/* Завдання 2. Використовуючи колекцію, підвійте слово:
    1. Введіть із клавіатури 5 слів до списку рядків.
    2. Метод doubleValues повинен підвоювати слова за принципом a, b, c -> a, a, b, b, c, c.
    3. Використовуючи цикл for виведіть результат на екран, кожне значення нового рядка.
*/
package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Step2 {

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        final int SIZE = 5;

        String s;
        for (int i = 0; i < SIZE; i++) {
            try {
                System.out.print("Введіть слово № " + (i + 1) + "/" + SIZE + ": ");
                s = reader.readLine();
                list.add(s);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
        System.out.println("Початковий список  : " + list);
        System.out.println("Результат подвоєння: " + doubleValues(list));
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--)
            list.add(i, list.get(i));
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Step2.run();
    }
}
