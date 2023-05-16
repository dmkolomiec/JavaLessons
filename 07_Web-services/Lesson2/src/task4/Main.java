/**
 * Задание 4
 * Создать xml-документ candies.xml, с корневым элементом , который будет в себе содержать несколько , c характеристиками конфеты.
 * Используя StAX-парсер получить коллекцию Candy из xml-файла.
 */
package task4;

import task4.entity.Candies;

public class Main {
    public static void main(String[] args) {
        String resourceDir = ""; // ""src/main/resources/";
        String xmlPath = resourceDir + "candies.xml";
        String xmlNewPath = resourceDir + "candies_out.xml";
        Candies candies;

        System.out.println("Парсер StAX with XMLStreamReader:");
        candies = UtilXml.parseStAxStream(xmlPath);
        candies.getCandy().forEach(System.out::println);

        if (UtilXml.demarshallXmlStAx(candies, xmlNewPath))
            System.out.println("\nСтворений файл: " + xmlNewPath);

    }
}
