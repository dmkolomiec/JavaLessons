package carsshopwebservice;

import gs_producing_web_service.GetCarRequest;
import gs_producing_web_service.GetCarResponse;
import gs_producing_web_service.GetClientRequest;
import gs_producing_web_service.GetClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CarsShopEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private CarsShopRepository carsShopRepository;
    @Autowired
    public CarsShopEndpoint(CarsShopRepository carsShopRepository) {
        this.carsShopRepository = carsShopRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientRequest")
    @ResponsePayload
    public GetClientResponse getClient(@RequestPayload GetClientRequest request) {
        GetClientResponse response = new GetClientResponse();
        response.setClient(carsShopRepository.findClient(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCar(@RequestPayload GetCarRequest request) {
        GetCarResponse response = new GetCarResponse();
        response.setCar(carsShopRepository.findCar(request.getId()));

        return response;
    }

}
