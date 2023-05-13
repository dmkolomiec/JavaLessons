
package task5.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


@XmlRootElement(name = "dimensions")
public class Dimensions {

    protected BigDecimal length;
    protected BigDecimal wingspan;
    protected BigDecimal height;

    public BigDecimal getLength() {
        return length;
    }

    @XmlElement(required = true)
    public void setLength(BigDecimal value) {
        this.length = value;
    }

    public BigDecimal getWingspan() {
        return wingspan;
    }

    @XmlElement(required = true)
    public void setWingspan(BigDecimal value) {
        this.wingspan = value;
    }

    public BigDecimal getHeight() {
        return height;
    }

    @XmlElement(required = false)
    public void setHeight(BigDecimal value) {
        this.height = value;
    }

    @Override
    public String toString() {
        return "размеры (ДxШxВ, м) : " + length + " x " + wingspan + (height==null? "": " x "+height);
    }
}
