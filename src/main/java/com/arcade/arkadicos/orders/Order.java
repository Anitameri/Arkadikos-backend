package com.arcade.arkadicos.orders;

import com.arcade.arkadicos.users.User;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
public class Order implements Serializable
{
    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    public Long getId()
    {
        return id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}