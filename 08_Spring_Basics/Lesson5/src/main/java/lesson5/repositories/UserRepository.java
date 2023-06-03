package lesson5.repositories;

import lesson5.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findUserByBirthDateBetween(Date date1, Date date2);

    List<User> findUserByGenderIsFalse();

    @Query( value = "DELETE FROM user WHERE userId = :userId", nativeQuery = true)
    @Modifying
    void myDeleteUserById(@Param("userId") Long userId);
}