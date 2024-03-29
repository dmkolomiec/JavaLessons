//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.25 at 02:59:16 PM EET 
//
package step4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "city")
public class City {

    @XmlElement(name = "city_info")
    public CityInfo cityInfo;

    @XmlElement(name = "street")
    protected List<Street> streets = new ArrayList<>();

    public City() {}

    public City(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

   void add(Street street) {
        streets.add(street);
    }

    @Override
    public String toString() {
        return cityInfo.toString() + "\nВулиці:" + streets.toString();
    }
}
