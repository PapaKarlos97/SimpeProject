package io.vladimir.easyApp.workingArea;

import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.models.Product;
import io.vladimir.easyApp.workingArea.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Test87 {

    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Person.class).addAnnotatedClass(Product.class).buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person1=session.get(Person.class,7);
            List<Product> productList=person1.getProducts();
            System.out.println(productList);



            session.getTransaction().commit();
        }finally {
            session.close();
        }


    }
}
