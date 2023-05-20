
package carsshopclient;

import carsshopclient.wsdl.GetCarRequest;
import carsshopclient.wsdl.GetCarResponse;
import carsshopclient.wsdl.GetClientRequest;
import carsshopclient.wsdl.GetClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CarsshopClient extends WebServiceGatewaySupport {
    private final String URI = "http://localhost:8080/ws/carsshop";
    private final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service/";

    private static final Logger log = LoggerFactory.getLogger(CarsshopClient.class);

    public GetClientResponse getClient(int id) {

        GetClientRequest request = new GetClientRequest();
        request.setId(id);

        log.info("Requesting data for client id = " + id);

        GetClientResponse response = (GetClientResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI, request, new SoapActionCallback(NAMESPACE_URI + "getClientRequest"));

        return response;
    }

    public GetCarResponse getCar(int id) {

        GetCarRequest request = new GetCarRequest();
        request.setId(id);

        log.info("Requesting data for car id = " + id);

        GetCarResponse response = (GetCarResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI, request, new SoapActionCallback(NAMESPACE_URI + "getCarRequest"));
        return response;
    }

}
