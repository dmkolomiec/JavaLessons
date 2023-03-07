/* Завдання 3. Створіть клас MyDictionary. Реалізуйте у найпростішому наближенні можливість використання його екземпляра.
   Мінімально необхідний інтерфейс взаємодії з екземпляром повинен включати метод додавання пар елементів,
   індексатор для отримання значення елемента за вказаним індексом і властивість тільки для читання для отримання загальної кількості пар елементів.
 */
package step3;


import java.util.ArrayList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyDictionary<String, String> md = new MyDictionary<>();
        md.add("обрій", "horizon");
        md.add("страус", "ostrich");
        md.add("путівець", "byroad");
        md.add("допіру", "until now");

        md.printTranslation("страус");
        md.printTranslation("шо");
        md.printTranslation("обрій");

        md.printByIndex(2);
        md.printByIndex(5);

    }
}

class WordPair<TKey, TValue> {
    private final TKey key;
    private final TValue value;

    public WordPair(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }

    public TKey getKey() {
        return key;
    }

    public TValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getKey() + " -> " + getValue();
    }
}

class MyDictionary<TKey, TValue> {
    ArrayList<WordPair<TKey, TValue>> dict = new ArrayList<>();

    public void add(TKey word1, TValue word2) {
        dict.add(new WordPair<TKey, TValue>(word1, word2));
    }

    public WordPair<TKey, TValue> translateOneWord(TKey key) throws PairNotFoundException {
        ListIterator<WordPair<TKey, TValue>> iterator = dict.listIterator();
        while (iterator.hasNext()) if (iterator.next().getKey() == key) return iterator.previous();

        throw new PairNotFoundException();
    }

    public void printTranslation(TKey key) {
        try {
            System.out.println(translateOneWord(key));
        } catch (PairNotFoundException e) {
            System.err.println(key + " -> " + e.getMessage());
        }
    }

    public WordPair<TKey, TValue> getByIndex(int index) {
        return dict.get(index);
    }

    public void printByIndex(int index) {
        try {
            System.out.println("№" + index + ". " + getByIndex(index));
        } catch (Exception e) {
            System.err.println("Пара с індексом " + index + " не знайдена");
        }
    }

}


class PairNotFoundException extends Exception {
    public PairNotFoundException() {
        super(" Переклад не знайдений.");
    }
}

