package translatorwebservice;

import gs_producing_web_service.GetTranslateRequest;
import gs_producing_web_service.GetTranslateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class TranslatorEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private TranslatorRepository translatorRepository;
    @Autowired
    public TranslatorEndpoint(TranslatorRepository translatorRepository) {
        this.translatorRepository = translatorRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTranslateRequest")
    @ResponsePayload
    public GetTranslateResponse translate(@RequestPayload GetTranslateRequest request) {
        GetTranslateResponse response = new GetTranslateResponse();
        response.setWord(translatorRepository.translate(request.getWord()));
        return response;
    }

}
