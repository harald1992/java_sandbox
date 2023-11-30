package com.harald.SpringRestCrudAPIs.controllers;

import com.harald.SpringRestCrudAPIs.entity.Employee;
import com.harald.SpringRestCrudAPIs.exceptions.EmployeeNotFoundException;
import com.harald.SpringRestCrudAPIs.services.EmployeeService_UseSpring_Jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeControllerSpringDataJPA {

    @Autowired
    EmployeeService_UseSpring_Jpa employeeService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id) throws Exception {
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employee.setId(0);
        Employee employeeDb = employeeService.create(employee);
        return ResponseEntity.ok(employeeDb);
    }


    @PutMapping("/")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee employeeDb = employeeService.update(employee);
        return ResponseEntity.ok(employeeDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
