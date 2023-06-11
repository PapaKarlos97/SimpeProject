package io.vladimir.easyApp.workingArea.controllers;

import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.enums.Position;
import io.vladimir.easyApp.workingArea.models.Product;
import io.vladimir.easyApp.workingArea.repository.PersonRepository;

import io.vladimir.easyApp.workingArea.service.ServiceForPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {
    SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").
            addAnnotatedClass(Person.class).addAnnotatedClass(Product.class)
            .buildSessionFactory();

    private final PersonRepository personRepository;
    private final ServiceForPerson serviceForPerson;

@Autowired
    public MainController( PersonRepository personRepository, ServiceForPerson serviceForPerson) {
    this.personRepository = personRepository;
    this.serviceForPerson = serviceForPerson;
    }

    @RequestMapping("/")
    public String shoAll(Model model) {

        List<Person> peopleList;
        try (Session session = sessionFactory.getCurrentSession();) {
            session.beginTransaction();
            peopleList = session.createQuery("select p from Person p LEFT JOIN FETCH p.products").getResultList();
            session.getTransaction().commit();
        }
        model.addAttribute("people", peopleList);
        return "show";
    }

    @RequestMapping("/c")
    public String firstPage(){
    return "index";
}
@PostMapping("/")
public String getData(@RequestParam(value = "name",required = false) String name,
                      @RequestParam(value = "email",required = false) String mail,
                      @RequestParam(value = "positionPeople",required = false)Position position,
                      @RequestParam(value = "birth",required = false )
                      Date dateOfBirth,
                      Model model){

    Session session=sessionFactory.getCurrentSession();

    Person person = new Person(name, mail,position);

            person.setDateOfBirth(dateOfBirth);
    person.setCreatedAt(new Date());
    System.out.println(person);
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

    }else {

        model.addAttribute("result", "Users not found");

    }
    return "point";
}
@DeleteMapping("/{id}")
@ResponseBody
public String deletePerson(@PathVariable int id,Model model,@ModelAttribute("variable")Person person){

 return serviceForPerson.deleteById(person.getId());

}
@PostMapping("/{id}")
@ResponseBody
public String edit(@PathVariable("id")int id,Model model,
@ModelAttribute("p")Person person) {
//    Person personForUpdated = serviceForPerson.findById(id);
//
//   if (!Objects.equals(personForUpdated.getName(), person.getName()) && !Objects.equals(personForUpdated.getName(), "")) personForUpdated.setName(person.getName());
//
//    personForUpdated.setEmail(person.getEmail());
//    serviceForPerson.save(personForUpdated);
//    return person.getName()+", "+person.getEmail();

    serviceForPerson.update(person.getId(),person);
    return person.getName()+","+person.getEmail();
}
@GetMapping("/e{id}")
    public String updatePerson(@PathVariable int id, Model model){
    Person person= serviceForPerson.findById(id);
    model.addAttribute("p",person);


    return "updatePerson";
}
}
