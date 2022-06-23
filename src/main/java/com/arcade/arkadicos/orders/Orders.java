package com.arcade.arkadicos.orders;

import com.arcade.arkadicos.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Orders implements Serializable
{
    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    User consumer;

    @OneToMany
    private Set<Order> orderss;
}