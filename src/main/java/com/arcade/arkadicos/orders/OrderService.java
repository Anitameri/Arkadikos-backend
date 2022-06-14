package com.arcade.arkadicos.orders;

import com.arcade.arkadicos.products.Product;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return orders.findById(id).orElse(null);
    }

    public Product getProductByOrderId(Long id)
    {
        Order order = findById(id);
        return order == null ? null : order.getProduct();
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