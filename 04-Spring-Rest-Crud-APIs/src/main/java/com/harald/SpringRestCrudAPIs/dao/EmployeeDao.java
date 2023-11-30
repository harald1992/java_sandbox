package com.harald.SpringRestCrudAPIs.dao;

import com.harald.SpringRestCrudAPIs.entity.Employee;

import java.util.List;

public interface EmployeeDao {


    Employee create(Employee employee);
    List<Employee> getAll();

    Employee getById(int id);

    Employee update(Employee employee);

    void delete(int id);
}
