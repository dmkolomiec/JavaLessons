/* Завдання 3. У папці з прикладами ex_004_comparable.
   Дописати логіку, щоб метод compareTo() здійснив пошук за швидкістю (якщо ж швидкість у 2-х об'єктів дорівнює, то шукаємо за ціною) -> ціною -> моделі -> кольору машини.
 */
package step3;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(190, 8000, "BMW", "Red");
        Car c2 = new Car(190, 2000, "Opel", "Black");
        Car c3 = new Car(200, 10000, "BMW", "White");
        Car c4 = new Car(200, 8000, "BMW", "Yellow");
        Car c5 = new Car(200, 8000, "BMW", "Grey");
        Car[] c = {c1, c2, c3, c4, c5};

        System.out.println("Сортуєумо за: швидкістю -> ціною -> моделі -> кольору");
        System.out.println("======== ======== ==== ======");
        Arrays.sort(c);
        for (Car temp : c) {
            System.out.println(temp);
        }

        // Сортуєумо за: швидкістю -> ціною -> моделі -> кольору машини в зворотньому напрмку.
        Arrays.sort(c, new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                int temp = o2.speed - o1.speed;
                if (temp != 0) return temp;

                temp = o2.price - o1.price;
                if (temp != 0) return temp;

                temp = o2.model.compareTo(o1.model);
                if (temp != 0) return temp;

                return o2.color.compareTo(o1.color);
            }
        });

        System.out.println("Сортуєумо за: швидкістю -> ціною -> моделі -> кольору (зв.напр.)");
        System.out.println("======== ======== ==== ======");
        for (Car temp : c) {
            System.out.println(temp);
        }

    }
}