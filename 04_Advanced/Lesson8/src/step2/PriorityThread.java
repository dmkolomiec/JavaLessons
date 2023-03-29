package step2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PriorityThread extends Thread {
    public static int minTimeout = 2000; // ms
    public static int maxTimeout = 5000; // ms
    public static int loopCount = 3;
    public static boolean isPrintLog = true;
    public static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss:ms");

    public PriorityThread() {
    }

    public PriorityThread(String name) {
        setName(name);
    }

    public static void runLoop() {
        String threadName = Thread.currentThread().getName();
        try {
            for (int i = 1; i <= PriorityThread.loopCount; i++) {
                if (isPrintLog)
                    System.out.printf("%-12s. %9s  i = %d/%d\n", LocalTime.now().format(timeFormat), threadName, i, PriorityThread.loopCount);

                // Це "Затримка потоку" чи ні, хз.
                sleep((int) (PriorityThread.minTimeout + Math.random() * (PriorityThread.maxTimeout - PriorityThread.minTimeout))); // pause min...maxTimeout (ms)
            }
            System.out.printf("%-12s. %9s finished!\n", LocalTime.now().format(timeFormat), threadName);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddPriorityToName() {
        setName(getName() + "(pr." + getPriority() + ")");
    }

    @Override
    public void run() {
        PriorityThread.runLoop();
    }
}
