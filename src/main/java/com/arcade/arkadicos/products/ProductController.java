package com.arcade.arkadicos.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")

public class ProductController {

    @Autowired
    ProductService service;

@GetMapping("/api/products")
    public List<Product> getall(){
    return service.getAllProducts();

}

@PostMapping("/api/products/create")
    public Product product(@RequestBody Product p){
        return service.create(p);
    }


@GetMapping("/api/products/delete/{id}")
    public String delete(@PathVariable("id") Long id){

        service.deleteById(id);

        return "redirect:/api/products";
    }

@PutMapping("/api/products/update/")
    public String update(@RequestBody Product p){

//        service.getProductById(p.getId());
        service.update(p);

        return "redirect:/api/products";
    }

}
