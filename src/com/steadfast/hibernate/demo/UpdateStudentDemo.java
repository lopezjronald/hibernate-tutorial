package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object

            int studentId = 2;

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // NEW CODE

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            // Updating information
            System.out.println("Updating the student...");
            myStudent.setFirstName("Scooby");
            myStudent.setLastName("Doo");

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

            // NEW CODE

            // creating a session
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("Updating email for all students");
            session.createQuery("UPDATE Student SET email='foo@gmail.com' WHERE lastName = 'O''Brien'").executeUpdate();

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
