/**
 * Завдання 2
 * Створіть класи сутності, які відповідатимуть таблицям у БД.
 */
package lesson5.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;
    private String surname;
    private Date birthDate;
    private boolean gender;
    private String phone;
    private String email;

    // Конструктор без email
    public User(String name, String surname, Date birthDate, boolean gender, String phone) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
    }

    // Конструктор с email
    public User(String name, String surname, Date birthDate, boolean gender, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    // Конструктор с email
    public User(String name, String surname, boolean gender, String phone, String email) {
        this.name = name;
        this.surname = surname;
//        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public String getAddress() {
        throw new UnsupportedOperationException("method getAddress() not implemented");
    }
}
