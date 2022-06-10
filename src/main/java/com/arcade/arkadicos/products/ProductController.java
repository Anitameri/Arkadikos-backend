package com.arcade.arkadicos.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://127.0.0.1:8080")
public class ProductController
{
    private final ProductService service;

    public ProductController(ProductService service)
    {
        this.service = service;
        this.service.create(new Product("GameBoy", "Nintendo old console", 19.9f, "console retro", "gameboy.png"));
        this.service.create(new Product("PS2", "Sony old console", 24.9f, "console retro", "ps2.png"));
        this.service.create(new Product("Xbox360", "Microsoft old console", 22.95f, "console retro", "xbox360.png"));
    }

    @GetMapping("/api/products")
    public List<Product> getProducts()
    {
        return service.getAllProducts();
    }

    @PostMapping("/api/product/create")
    public List<Product> createProduct(@RequestBody Product product)
    {
        service.create(product);
        return service.getAllProducts();
    }
}