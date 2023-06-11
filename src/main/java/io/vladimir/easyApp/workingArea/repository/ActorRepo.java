package io.vladimir.easyApp.workingArea.repository;

import io.vladimir.easyApp.workingArea.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepo extends JpaRepository< Actor,Long> {

}
