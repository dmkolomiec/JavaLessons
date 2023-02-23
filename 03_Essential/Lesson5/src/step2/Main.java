/*
Завдання 2. Використовуючи Intelij IDEA, створити проект, пакет. Створити клас Zoo. У класі створити список, який записати 8 тварин через метод add(index, element).
            Вивести список у консоль.
*/
package step2;
public class Main {
    public static void main(String[] args) {
        Zoo z = new Zoo(8);
        z.add(0, "Слон");
        z.add(0, "Жираф");
        z.add(0, "Страус");
        z.add(0, "Пінгвін");
        z.add(0, "Лев");
        z.add(0, "Зубр");
        z.add(0, "Косуля");
        z.add(0, "Лось");
        z.Print();
    }

}
