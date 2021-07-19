package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object
//
            int studentId = 3;
//
//            // start a transaction
//            System.out.println("Beginning session transaction");
//            session.beginTransaction();
//
//            // NEW CODE
//
//            // retrieve student based on the id: primary key
//            System.out.println("\nGetting student with id: " + studentId);
//
//            Student myStudent = session.get(Student.class, studentId);
//
//            // Delete the student
//            System.out.println("Deleting student: " + myStudent);
//            session.delete(myStudent);
//
//            // commit transaction
//            System.out.println("Committing the transaction");
//            session.getTransaction().commit();

            // NEW CODE

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // Deleting student with id = 4
            studentId = 4;
            System.out.println("Deleting student with ID: " + studentId);
            session.createQuery("DELETE FROM Student WHERE id = " + studentId).executeUpdate();

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
