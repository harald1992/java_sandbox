package com.harald.SpringHibernateJPACRUD;

import com.harald.SpringHibernateJPACRUD.dao.StudentDao;
import com.harald.SpringHibernateJPACRUD.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            System.out.println("Runner running");
            createStudent(studentDao, "Paul");
            createMultipleStudents(studentDao);
            // readStudent(studentDao);
            // studentDao.getAllStudents();
            // List<Student> students = studentDao.searchForName();
            // List<Student> studentDaffy = studentDao.findByLastName("Duck");

            // studentDao.updateStudent("Scooby", 1);


            // studentDao.deleteStudent("Paul");

        };

    }

    private void createStudent(StudentDao studentDao, String firstName) {
        Student tempStudent = new Student(firstName, "Doe", "paul@example.com");
        studentDao.save(tempStudent);
        // System.out.println("saved student id = " + tempStudent.getId());
    }


    private void createMultipleStudents(StudentDao studentDao) {
        Student[] students = {new Student("Paul2", "Doe2", "lalala@example.com"), new Student("Paul3", "Doe3", "lalala@example.com"),
                new Student("Paul4", "Doe4", "lalala@example.com")};

        for (Student student : students) {
            studentDao.save(student);
        }
    }

    private void readStudent(StudentDao studentDao) {
        Student tempStudent = new Student("Daffy", "Duck", "daffy@example.com");
        studentDao.save(tempStudent);

        int id = tempStudent.getId();

        Student student = studentDao.findById(id);
        // System.out.println(student);
    }


}
