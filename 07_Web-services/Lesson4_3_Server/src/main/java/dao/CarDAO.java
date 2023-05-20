package dao;

import gs_producing_web_service.Car;

import java.sql.*;

public class CarDAO {

    public void add(Car car) {
        Connection connection;

        connection = getConnection();
        PreparedStatement statement;

        try {

            statement = connection.prepareStatement("INSERT INTO cars(mark_id, model, price) VALUES (?, ?, ?)");

            statement.setInt(1, car.getMarkId());
            statement.setString(2, car.getModel());
            statement.setBigDecimal(3, car.getPrice());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Car getById(int id) {
        Connection connection;
        PreparedStatement preparedStatement = null;

        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT c.* FROM cars as c WHERE c.id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBigDecimal(4));
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
