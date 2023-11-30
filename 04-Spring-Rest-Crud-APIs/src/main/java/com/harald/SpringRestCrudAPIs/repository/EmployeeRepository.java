package com.harald.SpringRestCrudAPIs.repository;


import com.harald.SpringRestCrudAPIs.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
