package task2;

import org.xml.sax.SAXException;
import task2.entity.Model;
import task2.entity.Planes;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.math.BigDecimal;

public class UtilXml {

    public static Planes parseSAX(String xmlPath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            Planes planes = new Planes();

            ParseHandler ch = new ParseHandler();

            File file = new File(xmlPath);
            parser.parse(file, ch);

//            planes.getModel() = ch.getModels();
            planes.setModel(ch.getModels());
            return planes;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Planes parseStAxStream(String xmlPath) {

        XMLInputFactory factory = XMLInputFactory.newFactory();
        Reader reader;
        try {
            reader = new FileReader(xmlPath);

            XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);
            Planes planes = new Planes();
            Model model = new Model();

            while (xmlStreamReader.hasNext()) {
                switch (xmlStreamReader.next()) {
                    case XMLStreamReader.START_ELEMENT:
                        switch (xmlStreamReader.getName().toString()) {
                            case "model":
                                model = new Model();
                                for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                    String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                    String attributeValue = xmlStreamReader.getAttributeValue(i);
                                    switch (attributeName) {
                                        case "family":
                                            model.setFamily(attributeValue);
                                        case "variant":
                                            model.setVariant(attributeValue);
                                    }
                                }
                                break;
                            case "manufacturer":
                                model.setManufacturer(xmlStreamReader.getElementText());
                                break;
                            case "price":
                                model.setPrice(new BigDecimal(xmlStreamReader.getElementText()));
                                break;
                            case "type":
                                model.setType(xmlStreamReader.getElementText());
                                break;
                            case "characteristics":
                                break;
                            case "crew":
                                model.getCharacteristics().setCrew(Short.parseShort(xmlStreamReader.getElementText()));
                                break;
                            case "maximumPayload":
                                model.getCharacteristics().getLoadParams().setMaximumPayload(Long.parseLong(xmlStreamReader.getElementText()));
                                break;
                            case "seating":
                                model.getCharacteristics().getLoadParams().setSeating(Integer.parseInt(xmlStreamReader.getElementText()));
                                break;
                            case "length":
                                model.getCharacteristics().getDimensions().setLength(new BigDecimal(xmlStreamReader.getElementText()));
                                break;
                            case "wingspan":
                                model.getCharacteristics().getDimensions().setWingspan(new BigDecimal(xmlStreamReader.getElementText()));
                                break;
                            case "height":
                                model.getCharacteristics().getDimensions().setHeight(new BigDecimal(xmlStreamReader.getElementText()));
                                break;

                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        if (xmlStreamReader.getName().toString().equals("model"))
                            planes.getModel().add(model);
                        break;
                }
            }
            return planes;

        } catch (FileNotFoundException | XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }
}
