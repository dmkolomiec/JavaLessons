package step4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city_info")
public class CityInfo {
    protected String name;
    protected String size;
    protected int population;
    protected boolean isCapital;

    public CityInfo(String name, String size, int population, boolean isCapital) {
        this.name = name;
        this.size = size;
        this.population = population;
        this.isCapital = isCapital;
    }
    public CityInfo() {
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "city_name")
    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    @XmlElement()
    public void setSize(String size) {
        this.size = size;
    }

    public int getPopulation() {
        return population;
    }

    @XmlElement()
    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    @XmlElement(name = "is_Capital")
    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return "Місто: " + name + (isCapital? " (столиця)" : "") + ", розмір: " + size + ", населення: " + population;
    }
}
