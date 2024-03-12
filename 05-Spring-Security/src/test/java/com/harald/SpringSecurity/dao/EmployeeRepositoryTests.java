package com.harald.SpringSecurity.dao;

import com.harald.SpringSecurity.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void saveEmployee() {
        // Create an Employee instance
        Employee employee = new Employee(1, "John", "Doe", "john@example.com");

        // Save the employee to the repository
        Employee savedEmployee = employeeRepository.save(employee);

        // Verify if the employee is saved
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getFirstName()).isEqualTo("John");
    }

    @Test
    public void findAll_returns_list_successfully() {
        //  given
        Employee employee = Employee.builder().id(5).build();

        // when
        Employee savedEmployee = employeeRepository.save(employee);

        //  then
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isEqualTo(5);
    }


    @Test
    public void find_returns_null_when_unsuccessful() {
        // given
        // when
        Optional<Employee> foundEmployee = employeeRepository.findById(123);

        // then
        Assertions.assertThat(foundEmployee).isEmpty(); // Check if the Optional is empty
    }

    @Test
    public void find_returns_employee_when_successful() {
        // given
        Employee employee = Employee.builder().firstName("Johnny").build();
        employeeRepository.save(employee);

        // when
        Optional<Employee> foundEmployee = employeeRepository.findById(employee.getId());

        // then
        Assertions.assertThat(foundEmployee).isPresent(); // Check if the Optional is present
        Assertions.assertThat(foundEmployee.get().getId()).isEqualTo(employee.getId()); // Check if the IDs match
    }

}
