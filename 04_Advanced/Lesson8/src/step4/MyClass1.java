package step4;

public class MyClass1 extends Thread {
    /**
     * Кількість циклів друку
     */
    static final int count = 15;
    private final MyCounter counter;
    private MyClass1 other;

    public MyClass1(MyCounter counter) {
        this.counter = counter;
    }

    public void setOther(MyClass1 other) {
        this.other = other;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {

            // Отримати щось від спільного об'єкта
            synchronized (counter) {
                System.out.println((getClass() == MyClass2.class ? "\t" : "") + getClass().getSimpleName() + ".counter = " + counter.getCounter());
            }
            // Пнути сусіда
            synchronized (other) {
                other.notify();
            }
            // Зачекати сусіда, лише якщо це не останній раз (!!)
            if (i != count) synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
