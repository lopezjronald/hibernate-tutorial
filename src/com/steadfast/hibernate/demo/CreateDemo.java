package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.model.Instructor;
import com.steadfast.hibernate.demo.model.InstructorDetail;
import com.steadfast.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
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

            // create objects
//            Instructor instructor = new Instructor("ronald", "lopez", "ronald.lopez@steadfast.com");
            Instructor instructor = new Instructor("chris", "leon", "chris.leon@steadfast.com");

//            InstructorDetail instructorDetail = new InstructorDetail("https://www.steadfast.com/youtube", "Steadfast!!!");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.chrisLo.com/youtube", "Working!!!");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            System.out.println("Beginning session transaction");
            session.beginTransaction();

            // save the instructor
            // this will ALSO save the instructor details objects
            System.out.println("Saving Instructor and Instructor Detail object...");
            session.save(instructor);

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
