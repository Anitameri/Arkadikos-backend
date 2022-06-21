package com.arcade.arkadicos.orders;

import com.arcade.arkadicos.products.ProductService;
import com.arcade.arkadicos.users.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class OrdersController
{
    private final OrdersService service;

    private final ProductService pservice;

    private final OrderService oservice;

    private final UserService uservice;

    public OrdersController(OrdersService service, ProductService pservice, OrderService oservice, UserService uservice)
    {
        this.service = service;
        this.pservice = pservice;
        this.oservice = oservice;
        this.uservice = uservice;
    }

    @PostMapping("/api/order/payment")
    boolean pay(@RequestBody List<OrderDto> dtos)
    {
        Orders ordes = new Orders();
        ordes.setConsumer(uservice.getUserById(dtos.get(0).getUser_id()).orElse(null));
        List<Order> ords = new ArrayList<>();
        for(OrderDto dto : dtos)
            ords.add(oservice.save(new Order(pservice.getProductById(dto.getProduct_id()).orElse(null), dto.getPrice(), dto.getUnits())));
        ordes.setOrderss(new HashSet<>(ords));
        service.save(ordes);
        return true;
    }
}