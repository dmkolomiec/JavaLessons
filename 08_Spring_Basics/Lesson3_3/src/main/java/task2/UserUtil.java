package task2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Value;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    static final String USERS_FILE_NAME = "/users.bin";
    public static String GetResourceDir() {

        try {
            return new ClassPathResource("").getFile().getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> loadUsers() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(GetResourceDir() + USERS_FILE_NAME));
            return (List<User>) is.readObject();
        } catch (Exception e) {
            return new ArrayList<User>();
        }
    }

    public static int saveOneUser(User user) {
        try {
            List<User> users = loadUsers();
            users.add(user);

            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(GetResourceDir() + USERS_FILE_NAME));
            os.writeObject(users);

            return users.size();
        } catch (Exception e) {
            return 0;
        }
    }
}
