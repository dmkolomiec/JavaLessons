/**
 * Завдання 3.
 * Створіть клас, використовуючи SAXParser, де опишіть ієрархію XML файлу. Необхідно, щоб проект створював XML-файл і будував дерево (місто, назва вулиці, будинок).
 * У місті використовуйте аттрибут (наприклад, <city size=”big>Kiev</city>).
 * Скоріш за все, так і є, та і сама назва Парсер на це вказує, що програма має саме читати (парсити щось)
 */
package step3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

class MyHandler extends DefaultHandler {
    // Поле, щоб вказати, що тег name почався
    boolean isNode = false;
    int bCount = 0;

    // Метод викликається, коли SAXParser "натикається" на початок тегу
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Якщо тег має ім'я name, ми цей момент відзначаємо - почався тег name
        qName = qName.toLowerCase();
        // трохи г-коду
        switch (qName) {
            case "city_name":
                System.out.print("Назва міста: ");
                isNode = true;
                break;
            case "is_capital":
                System.out.print("Столиця?:  ");
                isNode = true;
                break;
            case "population":
                System.out.print("Населення: ");
                isNode = true;
                break;
            case "size":
                System.out.print("Розмір: ");
                isNode = true;
                break;
            case "previous_name":
                System.out.print("Стара назва: ");
                isNode = true;
                break;
            case "street":
                if (bCount > 0) {
                    System.out.println("Кількіть будівель : " + bCount + "\n");
                    bCount = 0;
                }
                System.out.println("Вулиця:  " + attributes.getValue(0).trim());
                break;
            case "building":
                bCount++;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        if (bCount > 0) {
            System.out.println("Кількіть будівель : " + bCount + "\n");
            bCount = 0;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isNode) {
            System.out.println(new String(ch, start, length));
            isNode = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        final String fileName = "City.xml"; // Файл мусить бути в кореневому каталозі проєкту
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(fileName, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
