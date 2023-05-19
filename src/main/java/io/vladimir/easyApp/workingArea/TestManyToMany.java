package io.vladimir.easyApp.workingArea;

import io.vladimir.easyApp.workingArea.models.Actor;
import io.vladimir.easyApp.workingArea.models.Movie;
import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestManyToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class).buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();

        try(session){
            session.beginTransaction();
//            Actor actor=new Actor("Korney Soin",22);
            Movie movie=session.get(Movie.class,5);
            session.delete(movie);
            session.getTransaction().commit();


        }


    }
}
