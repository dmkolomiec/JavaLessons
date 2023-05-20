
package translatorclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class TranslatorClientConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in pom.xml !!!
		marshaller.setContextPath("translatorclient.wsdl");
		return marshaller;
	}

	@Bean
	public TranslatorClient carsShopClient(Jaxb2Marshaller marshaller) {
		TranslatorClient client = new TranslatorClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
