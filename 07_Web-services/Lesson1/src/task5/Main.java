/**
 * Задание 5
 *
 * Создать XML файл согласно заданииям выбрать один из вариантов на выбор:
 *
 * 1. Создать файл XML и соответствующую ему схему XSD.
 * 2. При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения.
 * 3. Сгенерировать класс, соответствующий данному описанию.
 * 4. Создать приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла. Для разбора использовать SAX, DOM и StAX парсеры.
 *      Для сортировки объектов использовать интерфейс Comparator.
 * 5. Произвести проверку XML-документа с привлечением XSD.
 * 6. Определить метод, производящий преобразование разработанного XML документа в документ, указанный в каждом задании.
 *
 *
 * 8. Самолеты.
 * Самолеты можно описать по следующей схеме:
 * — Model — название модели;
 * — Origin — страна производства;
 * — Chars (должно быть несколько) — характеристики, могут быть следующими: тип (пассажирский, грузовой, почтовый, пожарный, сельскохозяйственный), количество мест для экипажа, характеристики (грузоподъемность, число пассажиров), наличие радара;
 * — Parameters — длина (в метрах), ширина (в метрах), высота (в метрах);
 * — Price — цена (в талерах).
 * Корневой элемент назвать Plane.
 * С помощью XSL преобразовать XML-файл в формат HTML, при выводе отсортировать по стоимости
 */
package task5;

import task5.entity.Planes;

public class Main {
    public static void main(String[] args) {
        String resourceDir = ""; // ""src/main/resources/";
        String xsdPath = resourceDir + "planes_v3.xsd";
        String xmlPath = resourceDir + "planes_sample_v3.xml";
        String xsltPath = resourceDir + "planes_v3.xslt";
        String htmlPath = resourceDir + "planes_v3.html";
        Planes planes;

        UtilXml.validateWithXsd(xsdPath, xmlPath);
        UtilXml.generateHtml(xsltPath, xmlPath, htmlPath);

        System.out.println("Парсер JAXB:");
        planes = UtilXml.parseJAXB(xmlPath);
        planes.sort();
        planes.getModel().forEach(System.out::println);

        planes = null;
        System.out.println("Парсер DOM:");
        planes = UtilXml.parseDOM(xmlPath);
        planes.sort();
        planes.getModel().forEach(System.out::println);
    }
}