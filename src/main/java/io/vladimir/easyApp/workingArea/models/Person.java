package io.vladimir.easyApp.workingArea.models;

import io.vladimir.easyApp.workingArea.enums.Position;
import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private long id;
//   @OneToMany(mappedBy = "id_people")
//   private List<Product> products;

   private String name;
   private String email;
   private int salary;
   @Column(columnDefinition = "enum('SELLER','TESTER','DEVELOPER','MANAGER')")
   @Enumerated(EnumType.STRING)
   private Position position;
   public Person() {
   }

   public Person(String name, String email) {
      this.name = name;
      this.email = email;
   }

   public Person(String name, String email, int salary) {
      this.name = name;
      this.email = email;
      this.salary = salary;
   }

   public Person(String name, String email,  Position position) {
      this.name = name;
      this.email = email;
      this.position = position;
   }

   public Person(String name, String email, int salary, Position position) {
      this.name = name;
      this.email = email;
      this.salary = salary;
      this.position = position;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
   }

   public Position getPosition() {
      return position;
   }

   public void setPosition(Position position) {
      this.position = position;
   }
}
