/* Завдання 5. Використовуючи Intelij IDEA, створити клас Friends.
   За допомогою методів ArrayList додати масив імена друзів. Вивести список друзів, після вивести список друзів, відсортувавши в алфавітному порядку.
 */
package step5;

import java.util.ArrayList;
import java.util.Collections;

class Friends {
    ArrayList<String> list;

    {
        list = new ArrayList<>();
    }
}

public class Main {
    public static void main(String[] args) {
        Friends f = new Friends();
        f.list.add("Жора");
        f.list.add("Сирожа");
        f.list.add("Октай");
        f.list.add("Азамат");

        System.out.println(f.list.toString()+ "  (Created)");

        Collections.sort(f.list);
        System.out.println(f.list.toString() + "  (Sorted)");
    }
}
