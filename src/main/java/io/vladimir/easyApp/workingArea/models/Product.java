package io.vladimir.easyApp.workingArea.models;

import jakarta.persistence.*;

@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_product;

    @ManyToOne()
    @JoinColumn(name="id_person",referencedColumnName = "id")
    private Person owner;
    @Column(name = "product")
    private String product;
    @Column(name = "cost")
    private float cost;

    public Product() {
    }

    public Product(Person owner, String product, float cost) {
        this.owner = owner;
        this.product = product;
        this.cost = cost;
    }

    public long getId_product() {
        return id_product;
    }

    public void setId_product(long id_product) {
        this.id_product = id_product;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
