package io.vladimir.easyApp.workingArea.repository;

import io.vladimir.easyApp.workingArea.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {



}
