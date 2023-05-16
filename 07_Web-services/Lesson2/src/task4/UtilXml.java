package task4;

import task4.entity.Candies;
import task4.entity.Candy;

import javax.xml.stream.*;
import java.io.*;
import java.math.BigDecimal;

public class UtilXml {
    public static Candies parseStAxStream(String xmlPath) {

        XMLInputFactory factory = XMLInputFactory.newFactory();
        Reader reader;
        try {
            reader = new FileReader(xmlPath);

            XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);
            Candies candies = new Candies();
            Candy candy = new Candy();

            while (xmlStreamReader.hasNext()) {
                switch (xmlStreamReader.next()) {
                    case XMLStreamReader.START_ELEMENT:

                        switch (xmlStreamReader.getName().toString()) {
                            case "candy":
                                candy = new Candy();
                                for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                    String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                    String attributeValue = xmlStreamReader.getAttributeValue(i);
                                    if (attributeName.equals("name")) {
                                        candy.setName(attributeValue);
                                    }
                                }
                                break;
                            case "energy":
                                candy.setEnergy(Integer.parseInt(xmlStreamReader.getElementText()));
                                break;
                            case "type":
                                candy.setType(xmlStreamReader.getElementText());
                                break;
                            case "proteins":
                                candy.setProteins(new BigDecimal(xmlStreamReader.getElementText()));
                                break;
                            case "fats":
                                candy.setFats(new BigDecimal(xmlStreamReader.getElementText()));
                                break;
                            case "carbohydrates":
                                candy.setCarbohydrates(new BigDecimal(xmlStreamReader.getElementText()));
                                break;
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        if (xmlStreamReader.getName().toString().equals("candy"))
                            candies.getCandy().add(candy);
                        break;
                }
            }
            return candies;

        } catch (FileNotFoundException | XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean demarshallXmlStAx(Candies candies, String xmlPath) {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer;

        try {
            writer = factory.createXMLStreamWriter(new FileWriter(xmlPath));

            writer.writeStartDocument();
            writer.writeStartElement("candies");
            for (Candy candy : candies.getCandy()) {
                writer.writeStartElement("candy");
                writer.writeAttribute("name", candy.getName());

                writer.writeStartElement("energy");
                writer.writeCharacters(String.valueOf(candy.getEnergy()));
                writer.writeEndElement();

                writer.writeStartElement("type");
                writer.writeCharacters(candy.getType());
                writer.writeEndElement();

                writer.writeStartElement("proteins");
                writer.writeCharacters(String.valueOf(candy.getFats()));
                writer.writeEndElement();

                writer.writeStartElement("fats");
                writer.writeCharacters(String.valueOf(candy.getFats()));
                writer.writeEndElement();

                writer.writeStartElement("carbohydrates");
                writer.writeCharacters(String.valueOf(candy.getCarbohydrates()));
                writer.writeEndElement();
                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();
            return true;

        } catch (XMLStreamException | IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
