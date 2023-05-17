package io.vladimir.easyApp.workingArea;

import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test87 {

    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Person.class).buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();

        Person person = new Person("Kiril", "leopold", 800);

        try {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        }finally {
            session.close();
        }


    }
}
