package com.arcade.arkadicos.products;

import com.arcade.arkadicos.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

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

    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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