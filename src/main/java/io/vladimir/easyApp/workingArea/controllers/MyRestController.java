package io.vladimir.easyApp.workingArea.controllers;

import io.vladimir.easyApp.workingArea.repository.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/")
public class MyRestController {
private final ActorRepo actorRepo;

@Autowired
    public MyRestController(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }




}
