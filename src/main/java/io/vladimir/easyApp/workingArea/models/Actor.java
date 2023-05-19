package io.vladimir.easyApp.workingArea.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import javax.lang.model.element.Name;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_actor;
    @Column(name = "name_actor")
    private String name;
    @Column(name = "age")
    private int age;
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            name = "compatible",
            joinColumns = @JoinColumn (name = "id_actor"),
            inverseJoinColumns = @JoinColumn (name = "id_films")
    )
    List<Movie>movies;

    public Actor() {
    }

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
