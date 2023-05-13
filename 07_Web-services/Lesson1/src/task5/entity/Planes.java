package task5.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Planes", propOrder = {"model"})
@XmlRootElement(name = "planes")
public class Planes {

    @XmlElement(name = "model", required = true)
    //@XmlElement(name = "model")
    protected List<Model> model;

    public List<Model> getModel() {
        if (model == null) {
            model = new ArrayList<>();
        }
        return this.model;
    }

    public void sort() {
        model.sort((m1, m2) -> m1.getPrice().compareTo(m2.getPrice()));
    }
}
