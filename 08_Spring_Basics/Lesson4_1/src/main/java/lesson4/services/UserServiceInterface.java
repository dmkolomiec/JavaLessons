package lesson4.services;

import lesson4.UserNotFoundException;
import lesson4.entity.User;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface UserServiceInterface {
    List<User> findAll();

    User findUserByUserId(long userId) throws UserNotFoundException;

    User addUser(User user);

    User updateUser(User user);

    boolean deleteById(long userId);

    long count();

    List<User> findUserByBirthDateBetween(Date date1, Date date2);
    List<User> findUserByGenderIsFalse();

}
