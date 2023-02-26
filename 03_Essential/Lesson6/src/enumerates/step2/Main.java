/*
Завдання 2. Створіть проект за допомогою IntelliJ IDEA. Створіть перерахунковий тип (enum) Animals, що містить конструктор,
        який повинен набувати цілого числа (вік тварини), і містити перевантажений метод toString(),
        який повинен повертати назву екземпляра та вік тварини.
*/
package enumerates.step2;

//    "Ведмідь", "Вовк", "Зубр", "Кабан";
enum Animals {
    BEAR(20), WOLF(5), BISON(10), BOAR(8);
    private int age;

    Animals(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Тварюка: %s (%d років)", this.name(), this.age);
    }
}

public class Main {
    public static void main(String[] args) {

        for (Animals animal : Animals.values())
            System.out.println(animal.toString());
    }
}
