package io.vladimir.easyApp.workingArea.service;

import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServiceForPerson {
    private final PersonRepository personRepository;
    @Autowired
    public ServiceForPerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }
    public Person findById(int id){
         Optional<Person> findPerson =personRepository.findById(id);
    return findPerson.orElse(null);
    }
    public void save( Person person){
        personRepository.save(person);
    }


    public Person update(int id,Person personToUpdate){
    Optional<Person>person1=personRepository.findById(id);
    if (person1.isPresent()){
        Person originalPerson=person1.get();
    if (Objects.nonNull(personToUpdate.getName())&&!"".equalsIgnoreCase(personToUpdate.getName())){
        originalPerson.setName(personToUpdate.getName());
    }
    if (Objects.nonNull(personToUpdate.getEmail())&&!"".equalsIgnoreCase(personToUpdate.getEmail())){
    originalPerson.setEmail(personToUpdate.getEmail());
    }
    return personRepository.save(originalPerson);
    }else return null;
    }


    public String deleteById(int id){
    if (personRepository.findById(id).isPresent()){
        personRepository.deleteById(id);
        return "Person deleted successfully";
    }

        return "Person not find";
    }

}
