package controllers;

import lesson5.UserNotFoundException;
import lesson5.entity.User;
import lesson5.repositories.UserRepository;
import lesson5.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class TesterDao {

    // Період дат для тестування
    LocalDate date1 = LocalDate.of(1980, 1, 1);
    LocalDate date2 = date1.plusYears(20);

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    static List<User> usersList = new ArrayList<>();

    static {
        usersList.add(new User("Vasily", "Rogov", Date.valueOf("1990-01-01"), true, "+123456789012", "vasrog@email.com"));
        usersList.add(new User("Nadya", "Hyitruvata", Date.valueOf("1992-02-03"), false, "+123456789033", "nadhtr@email.com"));
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() throws InterruptedException {
        when(userRepository.findAll()).thenReturn(usersList);
        Assert.assertEquals(usersList, userService.findAll());
    }

    @Test
    public void findUserByBirthDateBetween() throws InterruptedException {
        when(userRepository.findUserByBirthDateBetween(Date.valueOf(date1), Date.valueOf(date2)))
                .thenReturn(usersList);
    }

    @Test(expected = UserNotFoundException.class)
    public void findUserByUserId() throws UserNotFoundException {
        userService.findUserByUserId(-1);
    }
}