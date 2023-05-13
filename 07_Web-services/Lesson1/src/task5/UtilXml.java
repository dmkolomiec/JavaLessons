
package task5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import task5.entity.Characteristics;
import task5.entity.Model;
import task5.entity.Planes;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class UtilXml {

    public static boolean validateWithXsd(String xsdPath, String xmlPath) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema;
        Source source;
        Validator validator;

        try {
            schema = schemaFactory.newSchema(new File(xsdPath));
            validator = schema.newValidator();
            source = new StreamSource(new File(xmlPath));
            validator.validate(source);
            System.out.println(xmlPath + ": валидация пройдена УСПЕШНО");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(xmlPath + ": валидация НЕ ПРОЙДЕНА");
            return false;
        }
    }

    public static boolean generateHtml(String xsltPath, String xmlPath, String htmlPath){
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer;

        try {
            transformer = factory.newTransformer(new StreamSource(new File(xsltPath)));
            transformer.transform(new StreamSource(new File(xmlPath)), new StreamResult(new File(htmlPath)));
            System.out.println("Создан файл: " + htmlPath);
            return true;
        } catch (TransformerException e) {
            e.printStackTrace();
            return false;
        }
    }

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

    public static Planes parseDOM(String xmlPath){

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
            Document document = db.parse(xmlPath);
            Element root = document.getDocumentElement();
            NodeList list = root.getElementsByTagName("model");
            Planes planes = new Planes();


            for (int i = 0; i < list.getLength(); i++) {
                Model model = new Model();

                model.setFamily(list.item(i).getAttributes().item(0).getNodeValue());
                model.setVariant(list.item(i).getAttributes().item(1).getNodeValue());
                model.setManufacturer(list.item(i).getChildNodes().item(1).getTextContent());
                model.setPrice(new BigDecimal(list.item(i).getChildNodes().item(3).getTextContent()));
                model.setType(list.item(i).getChildNodes().item(5).getTextContent());

                NodeList charcs = list.item(i).getChildNodes().item(7).getChildNodes();
                NodeList lp = charcs.item(3).getChildNodes();
                NodeList dims = charcs.item(5).getChildNodes();

                model.setCharacteristics(new Characteristics());
                model.getCharacteristics().setCrew(Short.parseShort(charcs.item(1).getTextContent()));
                model.getCharacteristics().getLoadParams().setMaximumPayload(Long.parseLong(lp.item(1).getTextContent()));
                model.getCharacteristics().getLoadParams().setSeating(Integer.parseInt(lp.item(3).getTextContent()));

                model.getCharacteristics().getDimensions().setLength(new BigDecimal(dims.item(1).getTextContent()));
                model.getCharacteristics().getDimensions().setWingspan(new BigDecimal(dims.item(3).getTextContent()));
                if (dims.item(5) != null)
                    model.getCharacteristics().getDimensions().setHeight(new BigDecimal(dims.item(5).getTextContent()));

                planes.getModel().add(model);
            }

            return planes;

        } catch (ParserConfigurationException | SAXException | IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }

    }

}
