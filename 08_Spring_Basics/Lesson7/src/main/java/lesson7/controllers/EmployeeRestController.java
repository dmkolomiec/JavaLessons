package lesson7.controllers;


import lesson7.models.Employee;
import lesson7.services.EmployeeSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestController {

    private EmployeeSimpleService employeeSimpleService;

    @Autowired
    public void setEmployeeSimpleService(EmployeeSimpleService employeeSimpleService) {
        this.employeeSimpleService = employeeSimpleService;
    }

    // Добавить/Обновить сотр-ка
    @PutMapping // (consumes = "application/json")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeSimpleService.addEmployee(employee);
    }

    // Удалить сотр-ка
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {

        Optional opt = employeeSimpleService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity("Працівник із ID = " + id + " не знайдений", HttpStatus.NOT_FOUND);

        employeeSimpleService.removeById(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    // Вернуть список
    @GetMapping(value = "/all")
    public List<Employee> listAllEmployee() {
        return employeeSimpleService.findAll();
    }

    // Найти одного сотрудника по Id
    @GetMapping("/byid")
    public ResponseEntity getEmployee(@RequestParam("id") Long id) {

        Optional opt = employeeSimpleService.findById(id);
        return opt.isPresent() ? new ResponseEntity(opt.get(), HttpStatus.OK) : new ResponseEntity("Працівник із ID = " + id + " не знайдений", HttpStatus.NOT_FOUND);
    }

    // Найти сотр-ка по имени : /rest/employee/byname?name=Имя
    @GetMapping("/byname")
    public List<Employee> findByName2(@RequestParam("name") String name) {
        return employeeSimpleService.findEmployeeByName(name);
    }

    // Найти сотр-ка по имени и позиции: /rest/employee/byname_pos?name=Имя&position=должность
    @GetMapping("/byname_pos")
    public List<Employee> findByNameAndPosition(@RequestParam("name") String name, @RequestParam("pos") String position) {
        return employeeSimpleService.findEmployeeByNameAndPosition(name, position);
    }

    // Найти сотр-ка по имени и телефону: /rest/employee/byname+ph?name=Имя&ph=подстрока
    @GetMapping("/byname_ph")
    public List<Employee> findByNameAndPhone(@RequestParam("name") String name, @RequestParam("ph") String phone) {
        return employeeSimpleService.findEmployeeByNameAndPhone(name, phone);
    }

}
