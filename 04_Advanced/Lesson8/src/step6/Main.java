/**
 * Завдання 6
 * Змінити завдання №5. Усі можливі способи (які Ви знаєте) вирішити проблему взаємного блокування.
 */
package step6;

import step5.DeadLockDemo;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        DeadLockDemo demo1 = new DeadLockDemo();
        DeadLockDemo demo2 = new DeadLockDemo();
        demo1.setNeighbour(demo2);
        demo2.setNeighbour(demo1);

        System.out.println("\nСпосіб 1.  Створити чергу demo1 <- main <- demo2");
        demo1.start();
        demo1.join();
        demo2.start();
        demo2.join(); // Очікуємо завершення demo2

        System.out.println("\nСпосіб 2. demo1 поставити на паузу, відновити після завершення demo2");
        System.out.println("----------------------");

        demo1 = new DeadLockDemo();
        demo2 = new DeadLockDemo();
        demo1.setNeighbour(demo2);
        demo2.setNeighbour(demo1);
        demo2.setWaitingObj(true);

        demo1.start();
        demo2.start();
        demo2.join();

        /**
         * @see step4.MyClass1.counter
         */
        System.out.println("\nСпосіб 3. Винести перехресний блокований ф-ціонал в третій клас (наприклад step4.MyClass1)");
    }
}
