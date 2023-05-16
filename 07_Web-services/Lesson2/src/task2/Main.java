/**
 * Задание 2
 * Из задания первого урока.
 * Сгенерировать класс, соответствующий данному описанию.
 * Создать приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла.
 * Для разбора использовать SAX, DOM и StAX парсеры.
 * Для сортировки объектов использовать интерфейс Comparator.
 */
package task2;

import task2.entity.Planes;

public class Main {
    public static void main(String[] args) {
        String resourceDir = ""; // ""src/main/resources/";
        String xmlPath = resourceDir + "planes.xml";
        Planes planes;

        System.out.println("Парсер StAX with XMLStreamReader:");
        planes = UtilXml.parseStAxStream(xmlPath);
        planes.sortByPrice();
        planes.getModel().forEach(System.out::println);


        System.out.println("\nПарсер SAX:");
        planes = UtilXml.parseSAX(xmlPath);
        planes.sortByPrice();
        planes.getModel().forEach(System.out::println);
    }
}