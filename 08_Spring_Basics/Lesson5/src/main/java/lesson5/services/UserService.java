package lesson5.services;

import com.google.common.collect.Lists;
import lesson5.UserNotFoundException;
import lesson5.entity.User;
import lesson5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public User findUserByUserId(long userId) throws UserNotFoundException {
        Optional<User> optional = userRepository.findById(userId);
        if(!optional.isPresent()) {
            throw new UserNotFoundException("User with userId = " + userId + " does not exist.");
        }
        return optional.get();

//        return userRepository.findUserByUserId(userId);
    }

    @Override
    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }


    @Override
    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public boolean deleteById(long userId) {
        boolean userIsNull = true;
        Optional<User> optional = userRepository.findById(userId);
        if (!optional.isPresent()) {
            System.out.println("User not found. Invalid id");
            return userIsNull;
        } else {
            User user = optional.get();
            //userRepository.delete(result);
            userRepository.myDeleteUserById(user.getUserId());
            return false;
        }
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public List<User> findUserByBirthDateBetween(Date date1, Date date2) {
        return userRepository.findUserByBirthDateBetween(date1, date2);
    }

    @Override
    public List<User> findUserByGenderIsFalse() {
        return userRepository.findUserByGenderIsFalse();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
