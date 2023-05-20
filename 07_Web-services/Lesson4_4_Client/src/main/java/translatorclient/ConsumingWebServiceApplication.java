
package translatorclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import translatorclient.wsdl.GetTranslateResponse;

@SpringBootApplication
public class ConsumingWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(TranslatorClient quote) {
        return args -> {
            String word;

            if (args.length > 0) {
                word = args[0];
            }

            word = "море";
            GetTranslateResponse response = quote.getWord(word);
            System.out.println(word + " -> " + response.getWord());

            word = "квасоля";
            response = quote.getWord(word);
            System.out.println(word + " -> " + response.getWord());

            word = "невідоме";
            response = quote.getWord(word);
            System.out.println(word + " -> " + response.getWord());

        };
    }

}
