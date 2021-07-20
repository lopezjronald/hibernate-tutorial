package com.steadfast.hibernate.demo;

import com.steadfast.hibernate.demo.model.Instructor;
import com.steadfast.hibernate.demo.model.InstructorDetail;
import com.steadfast.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
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

            // get instructor detail by primary key
            int id = 6;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("Found instructor detail: " + instructorDetail);

            // print the associated instructor
            System.out.println("Instructor Detail Instructor: " + instructorDetail.getInstructor());

            // Delete instructor detail
            System.out.println("Deleting InstructorDetail: " + instructorDetail);

            // remove the associated object reference
            // break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

            // commit transaction
            System.out.println("Committing the transaction");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
