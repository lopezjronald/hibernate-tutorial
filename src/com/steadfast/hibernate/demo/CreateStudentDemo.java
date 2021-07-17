package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {

        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object

            // create a student object
            System.out.println("Creating a new student object");
            Student student = new Student("Ronald", "Lopez", "ronald.lopez@steadfast.com");

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student object to database");
            session.save(student);

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
