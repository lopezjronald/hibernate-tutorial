package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.model.Course;
import com.steadfast.hibernate.demo.model.Instructor;
import com.steadfast.hibernate.demo.model.InstructorDetail;
import com.steadfast.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {

        // Create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            int id = 6;

            // get instructor from db
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Instructor: " + instructor);

            // get courses for the instructor
            System.out.println("Courses: " + instructor.getCourses());

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

            // close the session
            session.close();
            System.out.println("Session is now closed");

            // option 1: call getter method while session is open

            System.out.println("Courses: " + instructor.getCourses());


        } finally {
            sessionFactory.close();
        }

    }
}
