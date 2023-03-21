/**
 * Завдання 3. Створіть клас, в ньому визначте 3 поля, до цих полів створіть конструктори та методи.
 * Використовуючи рефлексію отримайте всю інформацію про поля, методи, конструктори, а також модифікатори доступу.
 **/
package step3;

import step2.ClassInfo;

class SampleClassStep3 {
    private final int i;
    private String s;
    private final boolean b;

    public SampleClassStep3(int i, String s, boolean b) {
        this.i = i;
        this.s = s;
        this.b = b;
    }

    private SampleClassStep3() {
        this(1, "Завдання 3", true);
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}

public class Main {
    public static void main(String[] args) {
        ClassInfo.check(SampleClassStep3.class, true);
    }
}
