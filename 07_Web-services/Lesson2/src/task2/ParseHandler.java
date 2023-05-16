package task2;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import task2.entity.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ParseHandler extends DefaultHandler {

    private String currentQName;
    private List<Model> models;
    private Model model;

    public ParseHandler() {
        models = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentQName = qName;

        if (qName.equals("model"))
            for (int i = 0; i < attributes.getLength(); i++) {
                switch (attributes.getLocalName(i)) {
                    case "family":
                        model = new Model();
                        model.setFamily(attributes.getValue(i));
                        break;
                    case "variant":
                        model.setVariant(attributes.getValue(i));
                        break;
                }
            }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        switch (currentQName) {
            case "model":
                break;
            case "type":
                model.setType(value);
                break;
            case "manufacturer":
                model.setManufacturer(value);
                break;
            case "price":
                model.setPrice(new BigDecimal(value));
                break;
            case "crew":
                model.getCharacteristics().setCrew(Short.parseShort(value));
                break;
            case "maximumPayload":
                model.getCharacteristics().getLoadParams().setMaximumPayload(Long.parseLong(value));
                break;
            case "seating":
                model.getCharacteristics().getLoadParams().setSeating(Integer.parseInt(value));
                break;
            case "length":
                model.getCharacteristics().getDimensions().setLength(new BigDecimal(value));
                break;
            case "wingspan":
                model.getCharacteristics().getDimensions().setWingspan(new BigDecimal(value));
                break;
            case "height":
                model.getCharacteristics().getDimensions().setHeight(new BigDecimal(value));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentQName = "";
        if (qName.equals("model")) {
            models.add(model);
        }
    }

    public List<Model> getModels() {
        return models;
    }
}
