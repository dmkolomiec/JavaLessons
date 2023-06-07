package lesson7.repositories;

import lesson7.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// В качестве параметров здесь Employee - тип сущности, с которой будет работа
// Long - тип идентификатора(первичного ключа) данной сущности.
@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//    Данный интерфейс не содержит явно методы, но он наследует множество методов
//    из CrudRepository, реализация которых содержится в SimpleJpaRepository

    //    Прописывая название метода спринг будет помогать выбрать
//    действия и поля, по которым нужно выполнить работу
    List<Employee> findEmployeeByName(String name);

    List<Employee> findEmployeeByNameAndPosition(String name, String position);

    //Поиск по имени и телефону осущесвтляем с помощью аннотации @Query и можем прописывать sql запрос
//    Имя метода getPhone мы написали не пользуясь встроенными конструкциями репозитория
//    Можно использовать как первую так и вторую конструкцию. буква е - это аналогия знаку * в sql запросе
//    Но для второй конструкции нужно добавить @Param для указания параметров, которые будут передаваться из метода getPhone в sql запрос
//    @Query("select e from Employee e where e.name= ?1 and e.phone= ?2")
//    List<Employee> getPhone(String name, String phone);
    @Query("select e from Employee e where e.name= :name and e.phone like %:phone%")
    List<Employee> getPhone(@Param("name") String name, @Param("phone") String phone);

}
