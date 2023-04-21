package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {

    private final String URL = "jdbc:mysql://localhost:3306/myjoinsdb";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";
    private final String sqlFileName = "MyJoinsDB_Create_and_Fill.sql";

    FileReader fileReader;
    BufferedReader bufferedReader;
    String cmd = "", line;


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

        try {
            fileReader = new FileReader(sqlFileName);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                cmd  = cmd.concat(line).concat("\n");
                if(line.indexOf( ';') > 0) {
                    cmdList.add(cmd);
                    cmd = "";
                }
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Помилка під час завантаження файлу  " + sqlFileName);
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            for (String s : cmdList) {
                statement.addBatch(s);
            }

            int[] stat = statement.executeBatch();

            System.out.println("----- Команди -----");
            for (int i = 0; i < stat.length; i++) {
                System.out.println(i + ". " + cmdList.get(i) + " (статус " + stat[i] + ")");
            }

            ResultSet resultSet = statement.executeQuery("""
                    select p.*, c.birthDate, c.address, e.Salary, e.position
                     from person p
                    join contact c on c.personId = p.personId
                    join employee e on e.personId = p.personId""");
            System.out.println("\nId       ПІБ          Телефон        Д/Н           Адреса         Ставка    Посада");
            System.out.println(  "-- --------------- ------------- ---------- -------------------- -------- ----------");
            while (resultSet.next()) {
                System.out.printf("%2d %-15s %13s %10s %20s %8.2f %10s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getBigDecimal(6), resultSet.getString(7));
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
