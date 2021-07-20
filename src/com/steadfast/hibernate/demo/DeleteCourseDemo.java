package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.model.Course;
import com.steadfast.hibernate.demo.model.Instructor;
import com.steadfast.hibernate.demo.model.InstructorDetail;
import com.steadfast.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
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

            int id = 1;
            // get a course
            Course course = session.get(Course.class, id);

            // delete the course
            System.out.println("Deleting course: " + course);
            session.delete(course);

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
