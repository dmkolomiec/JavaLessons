package lesson7.services;

import com.google.common.collect.Lists;
import lesson7.models.Employee;
import lesson7.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeSimpleServiceImpl implements EmployeeSimpleService {
//    Осуществляем DI и получаем доступ к нашему репозиторию EmployeeRepository
    private EmployeeRepository employeeRepository;
//В репозитории уже есть методы, которые мы можем использовать: findAll, save, deleteById
    @Override
    public List<Employee> findAll() {
        return Lists.newArrayList(employeeRepository.findAll());
    }

    @Override
    public Optional<Employee> findById(long id) { return employeeRepository.findById(id); }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void removeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void listAllEmployee() {
        employeeRepository.findAll().forEach(elem -> System.out.println(elem.getId()));
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }


    @Override
    public List<Employee> findEmployeeByNameAndPosition(String name, String position) {
        return employeeRepository.findEmployeeByNameAndPosition(name, position);
    }

    @Override
    public List<Employee> findEmployeeByNameAndPhone(String name, String phone) {
        return employeeRepository.getPhone(name, phone);
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
