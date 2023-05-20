/**
 * Задание 2
 * * Из задания первого урока с помощью XPath распарсить XML-документ.
 */
package task2;

import task2.entity.Planes;

public class Main {
    public static void main(String[] args) {
        String resourceDir = ""; // ""src/main/resources/";
        String xmlPath = resourceDir + "planes.xml";
        Planes planes;

        System.out.println("Парсер XPath:");
        planes = UtilXml.parseXPath(xmlPath);
        planes.sortByPrice();
        planes.getModel().forEach(System.out::println);
    }
}
