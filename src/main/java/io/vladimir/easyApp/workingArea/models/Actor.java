package io.vladimir.easyApp.workingArea.models;

import jakarta.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor")
    private int id_actor;
    @Column(name = "nameActor")
    private String name;
    @Column(name = "age")
    private int age;
}
