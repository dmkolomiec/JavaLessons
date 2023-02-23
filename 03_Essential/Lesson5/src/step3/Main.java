/* Завдання 3. Використовуючи Intelij IDEA, створити проект, пакет.
               Використовуючи клас Zoo Завдання 2, видалити 3, 5, 7 тварин, дізнатися розмір списку і вивести в консоль.
*/
package step3;
public class Main {
    public static void main(String[] args) {
        Zoo2 z = new Zoo2(9);
        z.add(0, "Слон");
        z.add(0, "Жираф");
        z.add(0, "Страус");
        z.add(0, "Пінгвін"); //
        z.add(0, "Лев");
        z.add(0, "Зубр");
        z.add(0, "Косуля");
        z.add(0, "Лось");
        z.Print();

        System.out.println("\nВидалити 3:");
        z.delete(3);
        z.Print();

        System.out.println("\nВидалити 5:");
        z.delete(2);
        z.Print();

        System.out.println("\nВидалити 7:");
        z.delete(2);
        z.Print();
    }
}
