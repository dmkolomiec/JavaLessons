/**
 * Завдання 4
 * Створити 2 довільні класи з полями та методами. Необхідно синхронізувати методи цих класів між собою, тобто. щоб виводило на екран значення один за одним (1 клас, 2 клас, 1, 2 тощо).
 */
package step4;

public class Main {
    public static void main(String[] args) {
        MyCounter counter = new MyCounter();
        MyClass1 obj1 = new MyClass1(counter);
        MyClass2 obj2 = new MyClass2(counter);
        obj1.setOther(obj2);
        obj2.setOther(obj1);

        obj1.start();
        obj2.start();
    }
}
