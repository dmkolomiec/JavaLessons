package task4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import entity.FiRate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;


public class FiRateUtil {

    public static List<FiRate> loadRates(String CurCode) {
        String urlStr = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?" +
                (CurCode != null && CurCode.length()==3 ? "valcode=" + CurCode + "&" : "") +
                "date=20230526&json";
        URL url;
        try {
            url = new URL(urlStr);

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            JsonReader reader = new JsonReader(new InputStreamReader(url.openStream()));
            List<FiRate> rates = gson.fromJson(reader, new TypeToken<List<FiRate>>() {
            }.getType());
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

        return gson.toJson(rates).toString();
    }

}
