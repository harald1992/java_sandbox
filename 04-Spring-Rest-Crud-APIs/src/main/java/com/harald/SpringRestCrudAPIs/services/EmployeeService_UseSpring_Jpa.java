package com.harald.SpringRestCrudAPIs.services;

import com.harald.SpringRestCrudAPIs.entity.Employee;
import com.harald.SpringRestCrudAPIs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService_UseSpring_Jpa {

    @Autowired
    private EmployeeRepository employeeRepository;

    // @Transactional not needed with JpaRepository
    public Employee create(Employee employee) {
        employee.setId(0);  // so it creates and doesn't update
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        Employee employee = null;
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Couldn't find employee");
        }
        return employee;
    }

    // @Transactional not needed with JpaRepository
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    // @Transactional not needed with JpaRepository
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}
