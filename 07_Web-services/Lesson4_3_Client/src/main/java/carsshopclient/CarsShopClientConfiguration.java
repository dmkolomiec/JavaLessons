
package carsshopclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CarsShopClientConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in pom.xml !!!
		marshaller.setContextPath("carsshopclient.wsdl");
		return marshaller;
	}

	@Bean
	public CarsshopClient carsShopClient(Jaxb2Marshaller marshaller) {
		CarsshopClient client = new CarsshopClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
