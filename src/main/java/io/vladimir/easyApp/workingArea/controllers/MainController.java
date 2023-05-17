package io.vladimir.easyApp.workingArea.controllers;

import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.enums.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
@RequestMapping("/")
    public String firstPage(){
    return "index";
}
@PostMapping("/")
public String getData(@RequestParam(value = "name",required = false) String name,
                      @RequestParam(value = "email",required = false) String mail,
                      @RequestParam(value = "positionPeople",required = false)Position position,
                      Model model){
    SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").
            addAnnotatedClass(Person.class).buildSessionFactory();
    Session session=sessionFactory.getCurrentSession();

    Person person = new Person(name, mail,position);

    try {
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }finally {
        session.close();
    }


    model.addAttribute("resMsg",name+", you mail is "+mail+", your position is "+position);
    return "result";
}

}
