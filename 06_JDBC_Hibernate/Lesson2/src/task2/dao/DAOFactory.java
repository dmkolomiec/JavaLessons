package task2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    private static DAOFactory instance;
    private static Connection connection;

    private DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ""com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public static Connection getConnection() {
        try {
            if (connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "root");
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public static AlbumDAO getAlbumDAO() {
        return new AlbumDAO();
    }

}
