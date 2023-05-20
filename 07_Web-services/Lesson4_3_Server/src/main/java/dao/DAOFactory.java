package dao;

public class DAOFactory {

    private static DAOFactory factory;

    private DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }

    public ClientDAO getClientDAO() {
        return new ClientDAO();
    }
    public CarDAO getCarDAO() {
        return new CarDAO();
    }

}
