package task4_rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TranslateController {

    private static final Map<String, String> words = new HashMap<>();

    public TranslateController() {
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

	@GetMapping("/{word}")
	public String translate(@PathVariable String word) {
        String retval = words.get(word);
        if (retval == null)
            retval = "Переклад відсутній у словнику";
		return word + "  ->  " +  retval;
	}
}
