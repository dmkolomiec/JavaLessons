package task5;
import task2.entity.Planes;
import task2.UtilXml;


public class Main {
    public static void main(String[] args) {

        String resourceDir = ""; // ""src/main/resources/";
        String xmlPath = resourceDir + "planes.xml";
        Planes planes;

        System.out.println("Парсер JAXB:");
        planes = UtilXml.parseJAXB(xmlPath);
        planes.sortByPrice();
        planes.getModel().forEach(System.out::println);


    }
}
