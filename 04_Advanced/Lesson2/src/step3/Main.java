/* Завдання 3. Мінімальне з N чисел (використовувати LinkedList):
1. Введіть із клавіатури число N.
2. Вважати N цілих чисел і заповнити ними список - метод getIntegerList.
3. Знайти мінімальне число серед елементів списку – метод getMinimum.
*/
package step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

class Step3 {

    LinkedList<Integer> list = new LinkedList<>();
    int n;

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Введіть кількість чисел N: ");
                n = Integer.parseInt(reader.readLine());
                if (n <= 0 || n > 40) throw new Exception("Повинна віконватись умова:  0 < N <= 40");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        getIntegerList();
        Integer minVal = getMinimum();

        System.out.println(list);
        System.out.println("Мінімальне значення: " + minVal);
    }

    private void getIntegerList() {
        for (int i = 0; i < n; i++)
            list.add((int) (Math.random() * 1000));
    }

    private Integer getMinimum() {
        Iterator<Integer> i = list.iterator();
        Integer min = list.getFirst();
        while (i.hasNext()) {
            Integer next = i.next();
            min = min < next ? min : next;
        }
        return min;
    }
}

public class Main {
    public static void main(String[] args) {
        new Step3().run();
    }
}