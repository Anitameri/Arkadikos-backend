package com.arcade.arkadicos.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Entity
//Con lombok en vez de hacer los getter y setters ponemos esto
@Getter
@Setter
public class Product implements Serializable
{
    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float price;
    private String category;
    private String image;
    private int units;
    private int rating;

    public Product(){

    }

    public Product(Long id, String name, String description, float price, String category, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public Product(String name, String description, float price, String category, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }
}