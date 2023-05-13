package task5.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "characteristics")
public class Characteristics {
    protected short crew;
    protected LoadParams loadParams;
    protected Dimensions dimensions;

    public Characteristics() {
        loadParams = new LoadParams();
        dimensions = new Dimensions();
    }
    public short getCrew() {
        return crew;
    }
    @XmlElement(required = true)
    public void setCrew(short value) {
        this.crew = value;
    }

    public LoadParams getLoadParams() {
        return loadParams;
    }

    @XmlElement(required = true)
    public void setLoadParams(LoadParams value) {
        this.loadParams = value;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    @XmlElement(required = true)
    public void setDimensions(Dimensions value) {
        this.dimensions = value;
    }


    @Override
    public String toString() {
        return "Характеристики: экипаж " + crew + " ч., " + loadParams + ", " + dimensions;
    }
}
