/*
    Задание 6
    Создать базу данных в Workbench и подключить к IntelijIdea и создать тестовую таблицу.
    Заполнить ее данными с помощью запросов MySQL в IntelijIdea.
    Используя JDBC написать пример выполнения всех запросов.

    *Разновидность задания №2
*/
package task6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {

    private final String URL = "jdbc:mysql://localhost:3306/myjoinsdb";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    public DBWorker() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Connection connection = null;
        Statement statement = null;

        List<String> cmdList = new ArrayList<>();
        cmdList.add("drop table if exists task1_6");
        cmdList.add("""
                create table task1_6 (
                \tid int not null auto_increment primary key,
                \tDescr varchar(30),
                \tts timestamp default CURRENT_TIMESTAMP)""");
        cmdList.add("insert into task1_6(Descr) select address from contact");

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            for (String s : cmdList) {
                statement.addBatch(s);
            }

            int[] stat = statement.executeBatch();

            System.out.println("----- Команди -----");
            for (int i = 0; i < stat.length; i++) {
                System.out.println(i + ". " + cmdList.get(i) + "; (статус " + stat[i] + ")");
            }

            ResultSet resultSet = statement.executeQuery("select * from task1_6");
            System.out.println("\nId         Descr                Timestamp");
            System.out.println(  "-- -------------------- ------------------------");
            while (resultSet.next()) {
                System.out.printf("%2d %-20s %20s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getTimestamp(3));
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
