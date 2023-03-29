/**
 * Завдання 3.
 * Демонстрація пріоритетів. Створити 2 класи PriorityRunner та PriorityThread.
 * Запустити 3 потоки із пріоритетами (min, max, norm). З
 * а допомогою циклу for виведемо на екран значення від 1 до 50 і вкажемо, який саме потік цю операцію робить.
 */
package step3;

import step2.PriorityThread;

public class PriorityRunner {
    public static void main(String[] args) {
        int[] priorities = {Thread.MIN_PRIORITY, Thread.NORM_PRIORITY, Thread.MAX_PRIORITY};
        PriorityThread.minTimeout = PriorityThread.maxTimeout = 100;
        PriorityThread.loopCount = 50;
        PriorityThread.isPrintLog = true;

        for (int priority : priorities) {
            PriorityThread thread = new PriorityThread();
            thread.setPriority(priority);
            thread.AddPriorityToName();
            thread.start();
        }
    }
}
