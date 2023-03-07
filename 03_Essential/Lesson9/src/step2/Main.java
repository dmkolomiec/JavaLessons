/* Завдання 2. Створіть клас MyList. Реалізуйте у найпростішому наближенні можливість використання його екземпляра аналогічно екземпляру класу List.
   Мінімально необхідний інтерфейс взаємодії з екземпляром повинен включати метод додавання елемента, індексатор для отримання значення елемента
   за вказаним індексом і властивість тільки для читання для отримання загальної кількості елементів.
 */
package step2;

import java.util.Objects;

import static step2.MyList.*;

class SampleClass {
    private final int id;
    private final String name;

    public SampleClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "№" + id + ". " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SampleClass that = (SampleClass) o;

        if (id != that.id) return false;
        return Objects.equals(name, that.name);
    }
}


class MyList<T> {

    public static final int DELTA = 100;
    static final String ANSI_RESET = "\u001B[0m", ANSI_YELLOW = "\u001B[33m", ANSI_GREEN = "\u001B[32m";
    private T[] array;
    private int size = 0;

    public MyList(T[] array) {
        this.array = array;
        size = this.array.length;
    }

    public MyList() {
        array = (T[]) new Object[DELTA];
    }

    public int getSize() {
        return size;
    }

    private void extend() {
        T[] newArray = (T[]) new Object[array.length + DELTA];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void add(T newValue) {
        if (getSize() == array.length) extend();
        array[size++] = newValue;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean contains(T e) {
        for (int i = 0; i < getSize(); i++)
            if (array[i].equals(e)) return true;
        return false;
    }

    public void remove(int index) {
        if (index >= 0 && index < getSize()) {
            for (int i = index + 1; i < getSize(); i++)
                array[i - 1] = array[i];
            array[--size] = null;
        }
    }

    @Override
    public String toString() {
        String retval = "[";
        for (int i = 0; i < getSize(); i++)
            retval += array[i].toString() + (i == getSize() - 1 ? "" : ", ");
        return retval + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        // MyList<String>
        System.out.println(ANSI_YELLOW + "------ MyList<String>" + ANSI_RESET);
        String[] sa = {"add", "clear", "contains", "isEmpty", "set", "size"};
        MyList<String> myList = new MyList<>(sa);
        System.out.println("toString: " + myList);
        System.out.println("size: " + myList.getSize());
        System.out.println("isEmpty: " + myList.isEmpty());

        myList.add("remove");
        myList.add("toString");
        System.out.println("toString: " + myList + " (після додавання)");
        System.out.println("size: " + myList.getSize());
        System.out.println("contains(\"toString\"): " + myList.contains("toString"));

        myList.remove(4);  // set
        System.out.println("toString: " + myList + " (після видалення 4-го)");
        System.out.println("size: " + myList.getSize());

        // MyList<sampleClass>
        System.out.println(ANSI_GREEN + "------ MyList<sampleClass>" + ANSI_RESET);
        MyList<SampleClass> myList2 = new MyList<>();
        myList2.add(new SampleClass(1, "Строка 1"));
        myList2.add(new SampleClass(2, "Строка 22"));
        myList2.add(new SampleClass(3, "Строка 333"));
        System.out.println("toString: " + myList2);
        System.out.println("size: " + myList2.getSize());

        myList2.remove(1);
        System.out.println("toString: " + myList2 + " (після видалення)");
        System.out.println("size: " + myList2.getSize());

        SampleClass searchElement = new SampleClass(2, "Строка 22");
        System.out.println("contains(\"" + searchElement + "\"): " + myList2.contains(searchElement));
        System.out.println("toString: " + myList2 + " (після видалення)");
        searchElement = new SampleClass(3, "Строка 333");
        System.out.println("contains(\"" + searchElement + "\"): " + myList2.contains(searchElement));
    }
}
