package com.harald.SpringRestCrudAPIs.controllers;

import com.harald.SpringRestCrudAPIs.dao.EmployeeDaoImpl;
import com.harald.SpringRestCrudAPIs.entity.Employee;
import com.harald.SpringRestCrudAPIs.services.EmployeeService;
import com.harald.SpringRestCrudAPIs.services.EmployeeServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDaoImpl dao;

    @Autowired
    private EmployeeService employeeService;

    @PostConstruct
    private void createDatabaseTable() {
        for (int i = 0; i < 15; i++) {
            Employee employee = new Employee("hans-" + (i+1));
         employeeService.create(employee);
        }
    }

    // @GetMapping("/basic/all")    // doesn work since @Transactional is now in the service layer.
    // public List<Employee> getAllEmployeesDao() {
    //     return dao.getAll();
    // }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            throw new RuntimeException("Employee Not Found");
        }
        return ResponseEntity.ok(employee);
    }


    @PostMapping("/")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.deleteById(id);
    }


}
