//package io.vladimir.easyApp.workingArea.controllers;
//
//import io.vladimir.easyApp.workingArea.models.Person;
//import io.vladimir.easyApp.workingArea.models.Product;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/people")
//public class MainRestController {
//
//    SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
//            addAnnotatedClass(Person.class)
//            .buildSessionFactory();
//    Session session=factory.getCurrentSession();
//
//@RequestMapping("/")
//    public String all(Model model){
//    List<Person> peopleList;
//    try {
//        session.beginTransaction();
//        peopleList = session.createQuery("from person ").getResultList();
//        session.getTransaction().commit();
//    }finally {
//        factory.close();
//    }
//    model.addAttribute("people",peopleList);
//    return "all";
//}
//
//}
