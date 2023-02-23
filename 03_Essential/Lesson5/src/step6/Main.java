/*  Завдання 6. Використовуючи Intelij IDEA, створити проект, пакет.
                Створити class Main, у ньому створити список, додати вчителів, яких ви зможете згадати зі школи.
                І отримати індекс найкращого вчителя та самого не дуже. Вивести список у консоль.
*/
package step6;
import java.util.ArrayList;

public class Main {
    static final String BESTTEACHER  = "Ярослав Гашек";
    static final String WORSTTEACHER = "Олексій Толстой";
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Володимир Войнович");
        list.add(WORSTTEACHER);
        list.add("Варлам Шаламов");
        list.add(BESTTEACHER);
        list.add("Фазіль Іскандер");
        list.add("Джордж Орвелл");
        System.out.println(list.toString());

        System.out.printf("Iндекс найкращого вчителя (%s) = %d\n", BESTTEACHER,  list.indexOf(BESTTEACHER));
        System.out.printf("Iндекс найгіршого вчителя (%s) = %d\n", WORSTTEACHER, list.indexOf(WORSTTEACHER));
    }
}
