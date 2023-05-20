
package translatorclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import translatorclient.wsdl.GetTranslateRequest;
import translatorclient.wsdl.GetTranslateResponse;

public class TranslatorClient extends WebServiceGatewaySupport {
    private final String URI = "http://localhost:8080/ws/translator";
    private final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service/";

    private static final Logger log = LoggerFactory.getLogger(TranslatorClient.class);


    public GetTranslateResponse getWord(String word) {

        GetTranslateRequest request = new GetTranslateRequest();
        request.setWord(word);

        log.info("Requesting data for word = " + word);

        GetTranslateResponse response = (GetTranslateResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI, request, new SoapActionCallback(NAMESPACE_URI + "getClientRequest"));

        return response;
    }

}
