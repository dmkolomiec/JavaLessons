package lesson7.services;

import lesson7.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeSimpleService {
    List<Employee> findAll();

    Employee addEmployee(Employee employee);

    void removeById(long id);

    void listAllEmployee();

    List<Employee> findEmployeeByName(String name);
    Optional<Employee> findById(long id);

    List<Employee> findEmployeeByNameAndPosition(String name, String position);

    List<Employee> findEmployeeByNameAndPhone(String name, String phone);

}
