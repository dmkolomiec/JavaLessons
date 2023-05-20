package dao;

import gs_producing_web_service.Client;

import java.sql.*;

public class ClientDAO {

    public void add(Client client) {
        Connection connection = null;

        connection = getConnection();
        PreparedStatement statement;

        try {

            statement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");

            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getPhone());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Client getById(int id) {
        Connection connection;
        PreparedStatement preparedStatement = null;

        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT c.* FROM clients as c WHERE c.id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return new Client(rs.getInt(1), rs.getString(2), rs.getByte(3), rs.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {

                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private Connection getConnection() {
        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop", "root", "root");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
