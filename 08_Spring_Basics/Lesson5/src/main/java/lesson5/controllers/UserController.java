package lesson5.controllers;

import lesson5.StatInfo;
import lesson5.UserNotFoundException;
import lesson5.entity.User;
import lesson5.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceInterface userService;

    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String redirectPage() {
        return "redirect:index";
    }

    @GetMapping(value = "/add")
    public String getAddUser() {
        return "add.jsp";
    }


    // Метод добавления нового сотрудника
    @PostMapping(value = "/add")
    public String postAddUser(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setGender(request.getParameter("gender") != null);
        if (request.getParameter("birthDate") != null) {
            user.setBirthDate(Date.valueOf(request.getParameter("birthDate")));
        }
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));

        System.out.println("Доданий User id = " + userService.addUser(user).getUserId());
        return "redirect:/user/list";
    }

    @GetMapping("/delete={userId}")
    public String deleteUser(ModelMap mm, @PathVariable int userId) {
        boolean entityIsNull = userService.deleteById(userId);
        if (!entityIsNull) {
            return "redirect:/user/list";
        } else {
            mm.addAttribute("id", userId);
            return "error.jsp";
        }
    }

    @GetMapping(value = "/update={userId}")
    public String getUpdateUser(@PathVariable("userId") long userId, Model model) {
        try {
            User user = userService.findUserByUserId(userId);
            model.addAttribute("user", user);
            return "update.jsp";
        } catch (UserNotFoundException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            model.addAttribute("id", userId);
            return "error.jsp";
        }
    }

    @PostMapping(value = "/update")
    public String postUpdateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/user/list";
    }

    @GetMapping(value = "/list")
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("info", new StatInfo(userService.count()));
        modelAndView.setViewName("list.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/list1")
    public ModelAndView findUserByGenderIsFalse(ModelAndView modelAndView) {
        List<User> users = userService.findUserByGenderIsFalse();
        modelAndView.addObject("users", users);
        modelAndView.addObject("info", new StatInfo(users.size()));
        modelAndView.setViewName("list.jsp");
        return modelAndView;
    }

    @PostMapping(value = "/list2")
    public ModelAndView findUserByBirthDateBetween(@RequestParam("date1") Date date1,
                                                   @RequestParam("date2") Date date2,
                                                   ModelAndView modelAndView) {
        List<User> users = userService.findUserByBirthDateBetween(date1, date2);
        modelAndView.addObject("users", users);
        modelAndView.addObject("info", new StatInfo(users.size()));
        modelAndView.setViewName("list.jsp");
        return modelAndView;
    }


}
