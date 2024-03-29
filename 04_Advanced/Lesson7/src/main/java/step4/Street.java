//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.25 at 02:59:16 PM EET 
//


package step4;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "street")
public class Street {

    protected String name;
    protected String previousName;
    protected List<Integer> buildings = new ArrayList<>();

    public Street() {
    }

    public Street(String name, String previousName) {
        this.name = name;
        this.previousName = previousName;
    }

    public Street(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "street_name")
    public void setName(String value) {
        this.name = value;
    }

    public String getPreviousName() {
        return previousName;
    }

    @XmlElement(name = "previous_name")
    public void setPreviousName(String value) {
        this.previousName = value;
    }
    public void fillBuildings(int maxBuildings) {
        for (int i = 1; i < maxBuildings; i++)
            buildings.add(i);
    }

    public List<Integer> getBuildings() {
        return buildings;
    }

    @XmlElement(name = "building")
    public void setBuildings(List<Integer> value) {
        this.buildings = value;
    }

    @Override
    public String toString() {
        return "\nНазва: " + name + (previousName == null ? "" : "(" + previousName+ ")") +
               "\n\tБудинки: " + buildings.toString();
    }
}
