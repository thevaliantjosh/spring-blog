package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="coffees")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String roast;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false, length = 100)
    private String brand;

    @ManyToOne
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Constructors

    public Coffee() {
    }

    public Coffee(String brand) {
        this.brand = brand;
    }

    public Coffee(String roast, String brand) {
        this.roast = roast;
        this.brand = brand;
    }

    public Coffee(String roast, String origin, String brand, Supplier supplier) {
        this.roast = roast;
        this.origin = origin;
        this.brand = brand;
        this.supplier = supplier;
    }


}
