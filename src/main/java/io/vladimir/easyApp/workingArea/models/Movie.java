package io.vladimir.easyApp.workingArea.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "films")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_films")
    private int id_films;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;

    @ManyToMany(mappedBy = "movies")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Actor> actors;

    public Movie() {
    }

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getId_films() {
        return id_films;
    }

    public void setId_films(int id_films) {
        this.id_films = id_films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
