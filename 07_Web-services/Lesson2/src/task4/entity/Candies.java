
package task4.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Candies", propOrder = {
        "candy"
})
public class Candies {

    @XmlElement(required = true)
    protected List<Candy> candy;

    public List<Candy> getCandy() {
        if (candy == null) {
            candy = new ArrayList<>();
        }
        return this.candy;
    }

    @Override
    public String toString() {
        return candy.toString();
    }
}
