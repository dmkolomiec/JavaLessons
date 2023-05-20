package task2;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalDate rateDate = LocalDate.now();
        List<FiRate> rates = UtilGson.loadRates(rateDate);


        System.out.println("Масив об'єктів:");
        rates.forEach(System.out::println); // Печать java-объекта

        System.out.println("\nСтрока (JSON):");
        System.out.println(UtilGson.saveRatesToJsonString(rates).toString()); // печать строки json

        UtilGson.saveRatesToJsonFile(rates, rateDate); // Вывод json в файл
    }
}
