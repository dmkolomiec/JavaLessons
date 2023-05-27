package controllers;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import task2.UserUtil;
import task2.StatInfo;
import entity.User;

import java.util.List;

@Controller
public class Task2Controller {

    @GetMapping(value = "/input-data")
    public String passDataFromUser() {
        return "input-data.jsp";
    }

    // С нашей View, т.е. с pass-data.jsp к нам будут приходить данные, которые должны будут заполнить атрибуты класса User
    @PostMapping(value = "/input-data")
    public ModelAndView passDataFromUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {

        StatInfo info = new StatInfo(UserUtil.saveOneUser(user));
        // Префикс forward говорит спрингу, что данные, которые будут засэччены в ModelAndView
        // должны быть перенаправлены на страницу summary.jsp
        modelAndView.setViewName("summary.jsp");
        modelAndView.addObject("user", user);
        modelAndView.addObject("info", info);
        return modelAndView;
    }

    @GetMapping("/list-users")
    public ModelAndView listUsers() {
        List<User> users = UserUtil.loadUsers();
        System.out.println("userList.size() = " + users.size());

        ModelAndView modelAndView = new ModelAndView("list-users"); // указываем имя представления (JSP)
        modelAndView.addObject("users", users);
        modelAndView.addObject("info", new StatInfo(users.size()));
        modelAndView.setViewName("list-users.jsp");
        return modelAndView;
    }

}
