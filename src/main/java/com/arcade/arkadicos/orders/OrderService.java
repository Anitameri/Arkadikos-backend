package com.arcade.arkadicos.orders;

import org.springframework.stereotype.Service;

@Service
public class OrderService
{
    private final OrderRepository repo;

    public OrderService(OrderRepository repo)
    {
        this.repo = repo;
    }

    public Order save(Order o)
    {
        return repo.save(o);
    }
}