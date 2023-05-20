package task2;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import task2.entity.*;

public class UtilXml {

    public static Planes parseJAXB(String xmlPath){
        try {
            File file = new File(xmlPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Planes.class);
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            return (Planes) unmar.unmarshal(file);

        } catch (JAXBException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Planes parseXPath(String xmlPath) {

        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        XPathExpression expression;

        Planes planes = new Planes();

        try {
            File xml = new File(xmlPath);
            InputSource source = new InputSource(new FileInputStream(xml));
            expression = path.compile("//model");
            Object result = expression.evaluate(source, XPathConstants.NODESET);
            NodeList list = (NodeList) result;

            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                Model model= new Model();

                model.setFamily(list.item(i).getAttributes().getNamedItem("family").getTextContent());
                model.setVariant(list.item(i).getAttributes().getNamedItem("variant").getTextContent());

                model.setManufacturer(element.getElementsByTagName("manufacturer").item(0).getTextContent());
                model.setPrice(new BigDecimal(element.getElementsByTagName("price").item(0).getTextContent()));
                model.setType(element.getElementsByTagName("type").item(0).getTextContent());

                // Characterisrics
                Element elementChar = (Element)element.getElementsByTagName("characteristics").item(0);
                model.getCharacteristics().setCrew(Short.parseShort(elementChar.getElementsByTagName("crew").item(0).getTextContent()));
                // loadParams
                element = (Element)elementChar.getElementsByTagName("loadParams").item(0);
                model.getCharacteristics().getLoadParams().setMaximumPayload(Long.parseUnsignedLong(element.getElementsByTagName("maximumPayload").item(0).getTextContent()));
                model.getCharacteristics().getLoadParams().setSeating(Integer.parseUnsignedInt(element.getElementsByTagName("maximumPayload").item(0).getTextContent()));
                // dimensions
                element = (Element)elementChar.getElementsByTagName("dimensions").item(0);
                model.getCharacteristics().getDimensions().setLength(new BigDecimal(element.getElementsByTagName("length").item(0).getTextContent()));
                model.getCharacteristics().getDimensions().setWingspan(new BigDecimal(element.getElementsByTagName("wingspan").item(0).getTextContent()));

                if (element.getElementsByTagName("height").item(0) != null)
                    model.getCharacteristics().getDimensions().setHeight(new BigDecimal(element.getElementsByTagName("height").item(0).getTextContent()));

                planes.getModel().add(model);

            }
            return planes;

        } catch (XPathExpressionException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
