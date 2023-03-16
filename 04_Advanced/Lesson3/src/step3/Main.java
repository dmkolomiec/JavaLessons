/* Завдання 3. Необхідно створити рядок із текстом (текст взяти будь-який з інтернету).
                Розбити цей рядок на 2 підрядки рівної довжині та вивести на екран кожну (знову ця @#$%на невизначеність) речення з нового рядка.
*/
package step3;

import java.util.Scanner;

public class Main {
    final static String[] as1 = {"Перша", "Друга"};

    public static void main(String[] args) {
        String longStr = "Завдання 3. Необхідно створити рядок із текстом (текст взяти будь-який з інтернету). Розбити цей рядок на 2 підрядки рівної довжині та вивести на екран кожну речення з нового рядка.";
        int length = longStr.length();
        int half = length / 2;

        for (int i = 0; i < 2; i++) {
            String str = longStr.substring(i * half, (i + 1) * half); // (i+1)*half==length-1 ? length : (i+1)*half);
            System.out.printf("%s половина: [%s]\n----------\n", as1[i], str);

            Scanner s = new Scanner(str).useDelimiter(" ");

            int count = 1;
            while (s.hasNext()) {
                System.out.printf("%2d. %s\n", count++, s.next());
            }
            System.out.println("==========");
        }
    }
}
