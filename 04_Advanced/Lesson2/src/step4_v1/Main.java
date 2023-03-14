/* Завдання 4. Програма визначає, яка сім'я (прізвище) живе у місті. Приклад введення:
· Москва
· Іванови
· Київ
· Петрови
· Лондон
· Абрамовичі

Приклад введення:· Лондон
Приклад виведення: · Абрамовичі
 */
package step4_v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String searchKey;

        HashMap<String, String> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        map.put("Москва", "Іванови");
        map.put("Київ", "Петрови");
        map.put("Лондон", "Абрамовичі");

        while (true) try {
            System.out.print("Введіть ключ (допустимі значення " + map.keySet() + "): ");
            searchKey = reader.readLine();
            break;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (map.containsKey(searchKey)) System.out.println(searchKey + " -> " + map.get(searchKey));
        else System.out.println("В колекції на знайдений ключ '" + searchKey + "'");
    }
}