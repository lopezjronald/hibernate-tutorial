package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {

        // Create a session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            // use the session object to save the Java object

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // create a course
            Course course = new Course("Savageness - Growing a Savageness Mindset");

            // add some reviews
            course.addReview(new Review("Great course... loved it!!!!"));
            course.addReview(new Review("Cool course, job well done"));
            course.addReview(new Review("What a dumb course, you are an idiot!!!"));

            // save the course and leverage the cascade all :)
            System.out.println("Saving the course");
            System.out.println(course);
            session.save(course);

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
