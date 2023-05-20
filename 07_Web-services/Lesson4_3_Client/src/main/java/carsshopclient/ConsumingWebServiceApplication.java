
package carsshopclient;

import carsshopclient.wsdl.GetCarResponse;
import carsshopclient.wsdl.GetClientResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CarsshopClient quote) {
        return args -> {
            int id = 3;

            if (args.length > 0) {
                id = Integer.valueOf(args[0]);
            }

            GetClientResponse clientResponse = quote.getClient(2);
            System.out.println(clientResponse.getClient());


            GetCarResponse carResponse = quote.getCar(3);
            System.out.println(carResponse.getCar());

        };
    }

}
