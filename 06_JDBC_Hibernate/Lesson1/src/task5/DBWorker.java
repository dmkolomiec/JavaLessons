/*
    Задание 5
    Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
    1) Получите контактные данные сотрудников (номера телефонов, место жительства).
    2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
    3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
*/
package task5;

import java.sql.*;

public class DBWorker {

    private final String URL = "jdbc:mysql://localhost:3306/myjoinsdb";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    private final String strQuery1 = """
            select p.*, c.address
            from person p
            inner join contact c on c.personId = p.personId""";
    private final String strQuery2 = """
            select p.*, c.birthDate, c.family
            from person p
            inner join contact c on c.personId = p.personId and c.family = 'Single'""";
    private final String strQuery3 = """
            select p.*, c.birthDate, e.position
            from person p
            inner join employee e on e.personId = p.personId and e.position = 'Manager'
            inner join contact c on c.personId = p.personId""";
    public DBWorker() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // "com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            // 1) Получите контактные данные сотрудников (номера телефонов, место жительства)
            ResultSet resultSet = statement.executeQuery(strQuery1);
            System.out.println("Id       ПІБ          Телефон         Адреса");
            System.out.println("-- --------------- ------------- --------------------");
            while (resultSet.next()) {
                System.out.printf("%2d %-15s %-13s %-20s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),  resultSet.getString(4));
            }

            // 2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
            resultSet = statement.executeQuery(strQuery2);
            System.out.println("\nId       ПІБ          Телефон        Д/Н      Сім.ст.");
            System.out.println(  "-- --------------- ------------- ---------- ----------");
            while (resultSet.next()) {
                System.out.printf("%2d %-15s %-13s %10s %10s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),  resultSet.getDate(4), resultSet.getString(5));
            }
            // 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
            resultSet = statement.executeQuery(strQuery3);
            System.out.println("\nId       ПІБ          Телефон        Д/Н       Посада");
            System.out.println(  "-- --------------- ------------- ---------- ----------");
            while (resultSet.next()) {
                System.out.printf("%2d %-15s %-13s %10s %10s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),  resultSet.getDate(4), resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
