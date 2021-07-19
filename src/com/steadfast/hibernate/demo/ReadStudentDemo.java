package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object

            // create a student object
            System.out.println("Creating a new student object");
            Student student = new Student("Cristina", "O'Brien", "ronald.lopez@steadfast.com");

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student object to database");
            System.out.println(student);
            session.save(student);

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

            // NEW CODE

            // find the student's id: primary key
            System.out.println("Saved student. Generated id: " + student.getId());

            // now get the new session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + student.getId());

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get complete: " + myStudent);

            // commit the transaction
            session.getTransaction();

            System.out.println("Done!");

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
