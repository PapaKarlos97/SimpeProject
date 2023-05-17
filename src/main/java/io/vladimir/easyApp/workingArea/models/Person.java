package io.vladimir.easyApp.workingArea.models;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private long id;

   private String name;
   private String email;
   private int salary;

   public Person() {
   }

   public Person(String name, String email, int salary) {
      this.name = name;
      this.email = email;
      this.salary = salary;
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

}
