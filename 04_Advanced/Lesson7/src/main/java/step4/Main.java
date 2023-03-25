/** Завдання 4. Використовуючи JAXB, виконати завдання №3.
 * Завдання 3. Необхідно, щоб проект створював XML-файл і будував дерево (місто, назва вулиці, будинок).
 * У місті використовуйте аттрибут (наприклад, <city size=”big>Kiev</city>).
 */
package step4;

import javax.xml.bind.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] streetNames =  {"Хрещатик", "Бульвар Лесі Українки", "Вулиця Михайла Грушевського", "Вулиця Старонаводницка"};
        String[] streetOldNames =  {null, "Печерський бульвар", "Олександрівська", null};

        City city = new City(new CityInfo("Київ", "Великий", 3000_000, true));

        for (int i = 0; i<streetNames.length ; i++) {
            Street s = new Street(streetNames[i], streetOldNames[i]);
            s.fillBuildings(10 + (int) (Math.random() * 20));
            city.add(s);
        }

        try {
            File file = new File("City.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(City.class);

            Marshaller mar = jaxbContext.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(city, file);
            mar.marshal(city, System.out);

            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            city = (City) unmar.unmarshal(file);
            System.out.println("---------------------------");
            System.out.println(city);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
