package com.harald.SpringRestCrudAPIs.services;

import com.harald.SpringRestCrudAPIs.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    List<Employee> getAll();

    Employee getById(int id);

    Employee update(Employee employee);

    void deleteById(int id);


}
