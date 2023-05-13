/**
 * Задание 3
 * Используя работу с файлами вывести не все содержимое XML-документа, а только то, что находится внутри тега.
 * (Подсказка: используйте регулярные выражения).
 */
package task3;

public class Main {
    public static void main(String[] args) {
        XMLParser.run("planes_sample_v3.xml", "model");
    }
}
