package io.vladimir.easyApp.workingArea.service;

import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void update(int id,Person personToUpdate){
    personToUpdate.setId(id);
        personRepository.save(personToUpdate);
    }
    public void delete(int id){
        personRepository.deleteById(id);
    }
}
