package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object

            // create 3 student object
            System.out.println("Creating a new student object");
            Student student1 = new Student("Ronald", "Lopez", "ronald.lopez@steadfast.com");
            Student student2 = new Student("Chris", "Columbus", "chris.columbus@steadfast.com");
            Student student3 = new Student("Grace", "Period", "grace.period@steadfast.com");

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // save the student objects
            System.out.println("Saving 3 students object to database");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
