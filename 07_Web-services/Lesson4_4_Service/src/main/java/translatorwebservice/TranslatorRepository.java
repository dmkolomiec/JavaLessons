package translatorwebservice;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class TranslatorRepository {

    private static final Map<String, String> words = new HashMap<>();

    @PostConstruct
    public void initData() {
        words.put("книга", "book");
        words.put("квасоля", "bean");
        words.put("дощ", "rain");
        words.put("трава", "grass");
        words.put("море", "sea");
        words.put("сміття", "rubbish");
        words.put("дерево", "tree");
        words.put("ганчірка", "rag");
        words.put("папуга", "parrot");
        words.put("голуб", "dove");
        words.put("пам'ять", "memory");

    }

    public String translate(String word) {
        Assert.notNull(word, "The word must not be null");
        return words.get(word);
    }

}
