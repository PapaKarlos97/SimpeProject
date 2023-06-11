package io.vladimir.easyApp.workingArea.service;

import io.vladimir.easyApp.workingArea.models.Actor;
import io.vladimir.easyApp.workingArea.models.Person;
import io.vladimir.easyApp.workingArea.repository.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActorService {

private final ActorRepo actorRepo;
@Autowired
    public ActorService(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    public List<Actor> findAll(){
        return actorRepo.findAll();
    }

    public Actor findById(long id){
        Optional<Actor> findPerson = actorRepo.findById(id);
        return findPerson.orElse(null);
    }

    public void save(Actor actor){
    actorRepo.save(actor);
    }

    public String deleteById(long id){
        if (actorRepo.findById(id).isPresent()){
            actorRepo.deleteById(id);
            return "Person deleted successfully";
        }
        return "Person not find";
    }
    public Actor update(long id, Actor actor){
        Optional<Actor>actor1=actorRepo.findById(id);
        if (actor1.isPresent()){
            Actor orignalActor=actor1.get();
            if (Objects.nonNull(actor.getName())&&!"".equalsIgnoreCase(actor.getName())){
                orignalActor.setName(actor.getName());

            }
            return actorRepo.save(orignalActor);
        }else return null;
    }
}
