package io.vladimir.easyApp.workingArea.models;

import jakarta.persistence.*;

@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_product;

//    @ManyToOne()
//    @JoinColumn(name="id_people",referencedColumnName = "products")
//    private Person id_people;

    private String name;

    private float price;
}
