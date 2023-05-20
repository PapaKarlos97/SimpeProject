package io.vladimir.easyApp.workingArea.controllers;

import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.enums.Position;
import io.vladimir.easyApp.workingArea.repository.PersonRepository;
import io.vladimir.easyApp.workingArea.service.ServiceForPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final PersonRepository personRepository;
    private final ServiceForPerson serviceForPerson;

@Autowired
    public MainController(PersonRepository personRepository, ServiceForPerson serviceForPerson) {
    this.personRepository = personRepository;
    this.serviceForPerson = serviceForPerson;
    }

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

        @GetMapping("/{id}")
    public String readPeople(@PathVariable("id") int id, Model model){
    Person person= serviceForPerson.findById(id);

    if (person!=null) {
        model.addAttribute("result", "Hello dear " + person.getName());
        person.setName("Mr. "+person.getName());
        personRepository.save(person);

    }else {

        model.addAttribute("result", "Users not found");

    }
    return "point";
}

}
