package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


// persist, merge, remove, get method

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student1.class)
                .configure()
                .buildSessionFactory();

//        Session session = createInTable(sessionFactory);
//        Session session= readFromTable(sessionFactory);
//        Session session = updateTheTable(sessionFactory);
        Session session = deleteFromTheTable(sessionFactory);

        session.close();
        sessionFactory.close();
    }

    private static Session deleteFromTheTable(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Student1 s1 = session.get(Student1.class, 11);

        Transaction transaction = session.beginTransaction();
        session.remove(s1);

        transaction.commit();

        return session;
    }

    private static Session updateTheTable(SessionFactory sessionFactory) {
        Student1 s1 = new Student1();
        s1.setAge(21);
        s1.setName("Karnnn");
        s1.setRollNo(11);

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(s1);

        transaction.commit();

        return session;
    }

    private static Session readFromTable(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Student1 s2 = session.get(Student1.class, 10);
        System.out.println(s2);

        return session;
    }

    private static Session createInTable(SessionFactory sessionFactory) {
        Student1 student = new Student1();
        student.setAge(21);
        student.setName("Chakraborty");
        student.setRollNo(10);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();

        System.out.println(student);

        return session;
    }
}