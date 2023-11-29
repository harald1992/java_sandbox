package com.harald.SpringHibernateJPACRUD.dao;

import com.harald.SpringHibernateJPACRUD.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);  // FROM Student is based on entity, not on tableName
        return query.getResultList();
    }

    @Override
    public List<Student> searchForName() {
        // again, lastName = entity fieldName
        TypedQuery<Student> query2 = entityManager.createQuery("FROM Student WHERE lastName='Duck' OR firstName='Paul'", Student.class);
        return query2.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:DATA", Student.class);
        query.setParameter("DATA", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional // means it changes the database, if it is readonly operation this is not needed
    public void updateStudent(String name, int index) {
        Student student = entityManager.find(Student.class, index);
        student.setFirstName(name);
        entityManager.merge(student);   // update the entity
    }


    @Override
    @Transactional
    public void deleteStudent(String firstName) {
        String query = "FROM Student WHERE firstName = :name";

        List<Student> studentList = entityManager.createQuery(query, Student.class).setParameter("name", firstName).getResultList();
        // setParameter changes :name to the argument name
        for (int i = 0; i < studentList.size(); i++) {
            // System.out.println(studentList.get(i));
            entityManager.remove(studentList.get(i));
        }
        System.out.println(studentList);
    }

    private void deleteStudentSmith() {
        entityManager.createQuery("DELETE FROM Student WHERE lastName=`Smith`").executeUpdate();
    }

    private void deleteAllStudents() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }



}
