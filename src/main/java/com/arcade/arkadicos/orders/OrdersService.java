package com.arcade.arkadicos.orders;

import com.arcade.arkadicos.products.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrdersService
{
    private final OrdersRepository orders;

    public OrdersService(OrdersRepository orders)
    {
        this.orders = orders;
    }

    public List<Orders> all()
    {
        return orders.findAll();
    }

    public Orders findById(Long id)
    {
        return orders.findById(id).orElse(null);
    }

    public void save(Orders newOrder)
    {
        orders.save(newOrder);
    }

    public void deleteById(Long id)
    {
        orders.deleteById(id);
    }

    public Set<Order> getOrders(long id)
    {
        return findById(id).getOrderss();
    }

    public float getTotalPrice(long id)
    {
        float total = 0.f;
        Set<Order> ord = getOrders(id);
        for(Order o : ord)
            total += o.getPrice();
        return total;
    }

    public long getTotalUnits(long id)
    {
        long total = 0;
        Set<Order> ord = getOrders(id);
        for(Order o : ord)
            total += o.getUnits();
        return total;
    }
}