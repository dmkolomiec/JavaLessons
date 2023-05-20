package carsshopwebservice;

import dao.CarDAO;
import dao.ClientDAO;
import dao.DAOFactory;
import gs_producing_web_service.Car;
import gs_producing_web_service.Client;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CarsShopRepository {

    DAOFactory factory;

    @PostConstruct
    public void initData() {
        factory = DAOFactory.getInstance();
    }

    public Client findClient(int id) {
        ClientDAO clientDAO = factory.getClientDAO();

        Assert.notNull(id, "The client Id must not be null");
        return clientDAO.getById(id);
    }

    public Car findCar(int id) {
        CarDAO carDAO = factory.getCarDAO();

        Assert.notNull(id, "The car Id must not be null");
        return carDAO.getById(id);
    }
}
