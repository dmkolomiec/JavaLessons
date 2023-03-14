/* Завдання 5. Вводити з клавіатури рядки, доки користувач не введе рядок 'end':
    1. Створити перелік рядків.
    2. Ввести рядки з клавіатури та додати їх до списку.
    3. Вводити з клавіатури рядки, доки користувач не введе рядок "end". "end" не враховувати.
    4. Вивести рядки на екран, кожен з нового рядка.
 */
package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static final String END = "end";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        LinkedList<String> c = new LinkedList<>();
        try {
            do {
                System.out.print("Введіть слово № " + (c.size() + 1) + ": ");
                s = reader.readLine();
                if (!s.equals(END)) c.push(s);
            } while (!s.equals(END));

            while (!c.isEmpty()) System.out.println(c.poll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}