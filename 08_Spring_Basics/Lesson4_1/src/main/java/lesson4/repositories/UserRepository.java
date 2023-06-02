package lesson4.repositories;

import lesson4.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Завдання 3
 * Для створених у попередньому завданні сутностей створіть репозиторії для отримання та збереження даних у БД будь-яким із розглянутих на уроці методом.
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
/*
    List<User> findAll();

    User save(User user);

    long count();
*/

    /**
     * Завдання 4.
     * Створити репозиторій, який отримуватиме дані з БД.
     * У цьому репозиторії необхідно створити 2 методи, які отримуватимуть дані.
     * Запит має бути сформований за допомогою назв методів.
     */
    List<User> findUserByBirthDateBetween(Date date1, Date date2);

    List<User> findUserByGenderIsFalse();

    /**
     * Також створіть 2 методи. Один з методів буде оновлювати інформацію в БД,
     * а інший – видаляти дані за допомогою анотації @Query та нативного запиту бази (використовуючи параметр анотації nativeQuery=true)
     */
    @Query( value = "DELETE FROM user WHERE userId = :userId", nativeQuery = true)
    @Modifying
    void myDeleteUserById(@Param("userId") Long userId);

}