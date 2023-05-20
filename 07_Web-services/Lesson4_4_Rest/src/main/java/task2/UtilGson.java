package task2;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class UtilGson {

    public static List<FiRate> loadRates(LocalDate rateDate) {
        String urlStr = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=" + rateDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "&json";
        URL url;
        try {
            url = new URL(urlStr);

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            JsonReader reader = new JsonReader(new InputStreamReader(url.openStream()));
            List<FiRate> rates =  gson.fromJson(reader,  new TypeToken<List<FiRate>>() {}.getType());
            return rates;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String saveRatesToJsonString(List<FiRate> rates) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
//        System.out.println(gson.toJson(rates).getBytes());

        return gson.toJson(rates).toString();
    }

    public static boolean saveRatesToJsonFile(List<FiRate> rates, LocalDate rateDate) {
        String outFileName = "src/main/resources/nbu_rates_" + rateDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".json";
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        try {
            Files.write(Paths.get(outFileName), gson.toJson(rates).getBytes(), StandardOpenOption.CREATE);
            System.out.println("Створений файл: " + outFileName);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
