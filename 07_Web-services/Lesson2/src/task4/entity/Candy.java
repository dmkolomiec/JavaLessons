
package task4.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Candy", propOrder = {
        "energy",
        "type",
        "proteins",
        "fats",
        "carbohydrates"
})
public class Candy {
    @XmlSchemaType(name = "unsignedShort")
    protected int energy;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlElement(required = true)
    protected BigDecimal proteins;
    @XmlElement(required = true)
    protected BigDecimal fats;
    @XmlElement(required = true)
    protected BigDecimal carbohydrates;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String name;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int value) {
        this.energy = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public BigDecimal getProteins() {
        return proteins;
    }

    public void setProteins(BigDecimal value) {
        this.proteins = value;
    }

    public BigDecimal getFats() {
        return fats;
    }

    public void setFats(BigDecimal value) {
        this.fats = value;
    }

    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(BigDecimal value) {
        this.carbohydrates = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String toString() {
        return name + " (" + type + "), е.ц. " + energy + " кКал/100г, білки/жири/вуглеводи: " + proteins + " / " + fats + " / " + carbohydrates + " (г/100г)";
    }
}
