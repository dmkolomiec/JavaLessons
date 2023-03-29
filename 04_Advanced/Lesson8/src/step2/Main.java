/**
 * Завдання 2
 * Затримка потоку. Необхідно створити три потоки, кожних із цих потоків запустити (наприклад: main, second, first),
 * і коли ці потоки успішно відпрацюють – вивести на екран повідомлення (завершення потім first, second і main).
 */
package step2;

public class Main extends PriorityThread {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new PriorityThread(i == 0 ? "first" : "second").start();
        }
        PriorityThread.runLoop();
    }
}
