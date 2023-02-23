/* Завдання 4. Використовуючи Intelij IDEA, створити проект, пакет. Створити клас Main, створити список цілих чисел і за допомогою ListIterator
        пройтись по списку і збільшити значення на 1.
*/
package step4;
import java.util.ArrayList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< 10; i++)
            list.add((int)(Math.random()*100));
        System.out.println(list.toString());

        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext())
            iterator.set(iterator.next()+1);

        System.out.println(list.toString());


    }
}
