
package task5.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@XmlRootElement(name = "model")
public class Model {

    protected String manufacturer;
    protected BigDecimal price;
    protected String type;
    protected Characteristics characteristics;
    protected String family;
    protected String variant;

    public Model() {
        characteristics = new Characteristics();
    }

    public String getManufacturer() {
        return manufacturer;
    }
    @XmlElement()
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }
    public BigDecimal getPrice() {
        return price;
    }

    @XmlElement()
    public void setPrice(BigDecimal value) {
        this.price = value;
    }
    public String getType() {
        return type;
    }

    @XmlElement()
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public void setType(String value) { this.type = value;    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    @XmlElement()
    public void setCharacteristics(Characteristics value) { this.characteristics = value; }

    public String getFamily() {
        return family;
    }

    @XmlAttribute(name = "family", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    public void setFamily(String value) { this.family = value; }
    public String getVariant() {
        return variant;
    }

    @XmlAttribute(name = "variant", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    public void setVariant(String value) { this.variant = value; }
    @Override
    public String toString() {
        return manufacturer + " "  + family  + " " + variant +
                ", цена(долл) = " + price +
                ", тип: " + type +
                ". " + characteristics;
    }
}
