package com.arcade.arkadicos.orders;

import com.arcade.arkadicos.products.Product;
import com.arcade.arkadicos.users.User;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Order implements Serializable
{
    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    Timestamp created_at;
    int units;
}
//many 2 one hacia una tabla ( p) y otra m2o hacia user