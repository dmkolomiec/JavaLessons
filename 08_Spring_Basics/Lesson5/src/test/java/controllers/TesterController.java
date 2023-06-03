package controllers;

import lesson5.entity.User;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-context.xml"})
@WebAppConfiguration
@FixMethodOrder
public class TesterController {

    // Період дат для тестування
    LocalDate date1 = LocalDate.of(1980, 1, 1);
    LocalDate date2 = date1.plusYears(20);
    LocalDate birthDate = date1.plusYears(10);

    @Mock
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

/*
    @Mock
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
*/


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testControllerList() throws Exception {
        mockMvc.perform(get("/user/list")).andDo(print()).andExpect(view().name("list.jsp"));
    }

    @Test
    public void testControllerAddGet() throws Exception {
        mockMvc.perform(get("/user/add")).andDo(print()).andExpect(view().name("add.jsp"));
    }

// Цей тест додає порожній запис.
/*
    @Test
    public void testControllerAddPost() throws Exception {
        mockMvc.perform(post("/user/add").flashAttr("user", new User("Vasily", "Rogov", Date.valueOf(birthDate), true, "+123456789012", "vasrg@gmail.com")))
                .andExpect(status().is3xxRedirection()) // is2xxSuccessful())
                .andExpect(view().name("redirect:/user/list"))
                .andDo(print());
    }
*/

    @Test
    public void testControllerAddPost1() throws Exception {
        mockMvc.perform(post("/user/add")
                        .param("name", "Vasily").param("surname", "Rogov")
                        .param("birthDate", Date.valueOf(birthDate).toString()).param("gender", "true").param("phone", "+123456789012")
                        .param("email", "vasrog@email.com")
                        .flashAttr("user", new User()))
                .andExpect(status().is3xxRedirection()) //is2xxSuccessful())
                .andExpect(redirectedUrl("/user/list"))
                .andExpect(view().name("redirect:/user/list"))
                .andDo(print());
    }

    @Test
    public void testControllerAddPost2() throws Exception {
        mockMvc.perform(post("/user/add")
                        .param("name", "Nadya").param("surname", "Hyitruvata")
                        .param("birthDate", Date.valueOf(birthDate).toString()).param("gender", "false").param("phone", "+123456789333")
                        .param("email", "nadunk@email.com")
                        .flashAttr("user", new User()))
                .andExpect(status().is3xxRedirection()) //is2xxSuccessful())
                .andExpect(redirectedUrl("/user/list"))
                .andExpect(view().name("redirect:/user/list"))
                .andDo(print());
    }

    @Test
    public void testControllerFindByGenderIsFalse() throws Exception {
        ResultActions result = mockMvc.perform(get("/user/list1"));

        Object listObject = result
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getModelAndView().getModel().get("users");

        if (listObject instanceof List && !((List) listObject).isEmpty()) {
            List<User> users = (List<User>) listObject;
            System.out.println("Знайдено користівачів: " + users.size());
            System.out.println(users);

            result.andExpect(status().isOk())
                    .andExpect(view().name("list.jsp"))
                    .andExpect(model().attribute("users", users))
                    .andExpect(model().attributeExists("info"));
        } else {
            System.out.println("Не знайдено жодного користувача");
        }
    }

    @Test
    public void testControllerFindByBirthDateBetween() throws Exception {
        ResultActions result = mockMvc.perform(post("/user/list2")
                .param("date1", date1.toString())
                .param("date2", date2.toString()));

        Object listObject = result
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getModelAndView().getModel().get("users");

        if (listObject instanceof List && !((List) listObject).isEmpty()) {
            List<User> users = (List<User>) listObject;
            System.out.println("Знайдено користівачів: " + users.size());
            System.out.println(users);

            result.andExpect(status().isOk())
                    .andExpect(view().name("list.jsp"))
                    .andExpect(model().attribute("users", users))
                    .andExpect(model().attributeExists("info"));

            // Спроба видалення
            long userId = users.get(0).getUserId();
            System.out.println("Видалення userId = " + userId + "...");
            mockMvc.perform(get("/user/delete={id}", userId)).andExpect(status().is3xxRedirection());

        } else {
            System.out.println("Не знайдено жодного користувача");
        }
    }

}