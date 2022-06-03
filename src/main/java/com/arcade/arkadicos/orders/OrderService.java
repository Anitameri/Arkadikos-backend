package com.arcade.arkadicos.orders;

import com.arcade.arkadicos.users.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    private final OrderRepository orders;

    public OrderService(OrderRepository orders)
    {
        this.orders = orders;
    }

    public List<Order> all()
    {
        return orders.findAll();
    }

    public Order findById(Long id)
    {
        Optional<Order> opt = orders.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }

    public User getUserByOrderId(Long id)
    {
        return findById(id).getUser();
    }

    public void save(Order newOrder)
    {
        orders.save(newOrder);
    }

    public void deleteById(Long id)
    {
        orders.deleteById(id);
    }
}