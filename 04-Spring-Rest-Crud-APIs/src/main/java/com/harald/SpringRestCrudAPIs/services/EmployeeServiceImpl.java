package com.harald.SpringRestCrudAPIs.services;

import com.harald.SpringRestCrudAPIs.dao.EmployeeDaoImpl;
import com.harald.SpringRestCrudAPIs.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoImpl employeeDao;

    @Override
    @Transactional
    public Employee create(Employee employee) {
        return employeeDao.create(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
         employeeDao.delete(id);
    }

}
