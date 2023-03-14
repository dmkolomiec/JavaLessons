package step4_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key, val, searchKey;
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            try {
                System.out.print("Введіть ключ  № " + (i + 1) + ": ");
                key = reader.readLine();
                System.out.print("Введіть значення  № " + (i + 1) + ": ");
                val = reader.readLine();
                map.put(key, val);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }

        while (true) try {
            System.out.print("Введіть ключ (допустимі значення: " + map.keySet() + "): ");
            searchKey = reader.readLine();
            break;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (map.containsKey(searchKey)) System.out.println(searchKey + " -> " + map.get(searchKey));
        else System.out.println("В колекції на знайдений ключ '" + searchKey + "'");
    }
}

