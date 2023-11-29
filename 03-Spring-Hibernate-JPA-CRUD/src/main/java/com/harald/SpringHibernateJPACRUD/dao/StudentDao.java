package com.harald.SpringHibernateJPACRUD.dao;

import com.harald.SpringHibernateJPACRUD.entities.Student;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student findById(int id);

    List<Student> getAllStudents();

    List<Student> searchForName();

    List<Student> findByLastName(String lastName);

    void updateStudent(String name, int index);

    void deleteStudent(String firstName);
}
