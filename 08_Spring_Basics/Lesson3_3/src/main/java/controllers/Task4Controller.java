/**
 * Завдання 4
 * Створити новий контролер з різним мапінгом, який буде приймати тільки Get-запити та віддавати випадково згенеровану інформацію в JSON-форматі.
 * Наприклад,
 *      для мапінгу «/uuid» виводити випадково згенерований uuid,
 *      для мапінгу «/exchange» виводити випадкове значення курсу валют,
 *      для «/exchange/{currency}» виводити значення курсу валюти, переданої в змінному шляху «currency».
 *      Для реалізації завдання потрібно буде скористатися анотацією @ResponseBody.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import entity.FiRate;
import task4.FiRateUtil;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(produces = "application/json; charset=UTF-8")
public class Task4Controller {
    @GetMapping("/uuid")
    public @ResponseBody String getUUID() {
        return "{\"uuid\": \"" + UUID.randomUUID() + "\"}";
    }
    @GetMapping("/exchange")
    public @ResponseBody String getExchange() {
        List<FiRate> rates = FiRateUtil.loadRates("");
        for (FiRate rate: rates)
             rate.setRate((float)Math.random()*10);

        return FiRateUtil.saveRatesToJsonString(rates);
    }

    @GetMapping("/exchange/{curcode}")
    public @ResponseBody String getExchangeCurrency(@PathVariable String curcode) {
        List<FiRate> rates = FiRateUtil.loadRates(curcode);
        rates.get(0).setRate((float)Math.random()*10);
        return FiRateUtil.saveRatesToJsonString(rates);
    }

}
