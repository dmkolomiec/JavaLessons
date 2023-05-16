package task2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "loadParams")
public class LoadParams {

    protected long maximumPayload;
    protected int seating;

    public long getMaximumPayload() {
        return maximumPayload;
    }

    @XmlElement(required = true)
    public void setMaximumPayload(long value) {
        this.maximumPayload = value;
    }

    public int getSeating() {
        return seating;
    }

    @XmlElement(required = true)
    public void setSeating(int value) {
        this.seating = value;
    }

    @Override
    public String toString() {
        return "грузоподъёмность " + maximumPayload + " кг, пасс. " + seating;
    }
}
