package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // query students, get all students from the Database
            System.out.println("Displaying all students");
            List<Student> students = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(students);

            // query students with lastName = 'Lopez'
            students = session.createQuery("from Student where lastName = 'Lopez'").getResultList();

            // displaying students with last name 'lopez'
            System.out.println("Displaying all students with last name \"Lopez\"");
            displayStudents(students);

            // query students with lastName = 'Lopez'
            students = session.createQuery("from Student where lastName = 'Lopez' OR firstName = 'Cristina'").getResultList();

            // displaying students with last name 'lopez' or first name 'cristina'
            System.out.println("Displaying all students with last name \"Lopez\" or first name \"Cristina\"");
            displayStudents(students);

            // query students with email ending with  = 'steadfast.com'
            students = session.createQuery("from Student where email LIKE '%steadfast.com'").getResultList();

            // displaying students with last name 'lopez'
            System.out.println("Displaying all students with email ending in \"steadfast.com\"");
            displayStudents(students);

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for (Student student: students) {
            System.out.println(student);
        }
    }
}
