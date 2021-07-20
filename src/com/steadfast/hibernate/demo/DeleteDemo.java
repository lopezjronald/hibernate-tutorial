package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.model.Instructor;
import com.steadfast.hibernate.demo.model.InstructorDetail;
import com.steadfast.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // get instructor by primary key
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Found instructor: " + instructor);

            // delete the instructor by id and will also delete the "Details Object" associated with the instructor
            if (instructor != null ) {
                System.out.println("Deleting instructor: " + instructor);
                session.delete(instructor);
            }

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
