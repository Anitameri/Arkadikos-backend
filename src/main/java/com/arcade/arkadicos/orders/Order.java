package com.arcade.arkadicos.orders;

import com.arcade.arkadicos.products.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Order implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Product product;

    private float price;

    private long units;

    public Order(Product product, float price, long units)
    {
        this.product = product;
        this.price = price;
        this.units = units;
    }

    public Order(){}
}