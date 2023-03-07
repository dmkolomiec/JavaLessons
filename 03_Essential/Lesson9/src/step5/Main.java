/* Завдання 5. Створіть клас MyClass, що містить статичний фабричний метод - T factoryMethod(), який породжуватиме екземпляри типу,
    зазначеного як параметр типу (покажчика місця заповнення типом – Т).
 */
package step5;

public class Main {
    public static void main(String[] args) {
        System.out.println(MyClass.factoryMethod(new MyClass<>(555)));
        System.out.println(MyClass.factoryMethod(new MyClass<>("Моя строка")));
        System.out.println(MyClass.factoryMethod(new MyClass<>(new SampleClass("Билли", "Бонс"))));

        System.out.println(MyClass.factoryMethod(new MyClass<>(new SampleClass("Джон", "Сильвер"))).getClass());
    }
}

class MyClass<T> {
    private final T value;

    public MyClass(T value) {
        this.value = value;
    }

    public static <T> T factoryMethod(MyClass<T> myClass) {
        return myClass.getValue();
    }

    public T getValue() {
        return value;
    }

}

class SampleClass {
    protected String name, surname;

    public SampleClass(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + name + " " + surname;
    }
}
