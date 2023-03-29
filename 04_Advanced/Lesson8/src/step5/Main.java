/**
 * Завдання 5
 * Створити 2 класи. Реалізувати взаємне блокування цих класів.
 */
package step5;

public class Main {
    public static void main(String[] args) {
        DeadLockDemo demo1 = new DeadLockDemo();
        DeadLockDemo demo2 = new DeadLockDemo();
        demo1.setNeighbour(demo2);
        demo2.setNeighbour(demo1);

        demo1.start();
        demo2.start();

    }
}
