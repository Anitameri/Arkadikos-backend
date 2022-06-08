package com.arcade.arkadicos.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin("http://127.0.0.1:8080")

public class ProductController {
@GetMapping("/api/products")

    public List<Product> getProducts(){
    List<Product> productsList = new ArrayList<>();
    Product p = new Product(
            "Gameboy",
            "ashashoco",
            19,
            "consola retro",
            "https://upload.wikimedia.org/wikipedia/commons/f/f4/Game-Boy-FL.jpg"


    );
    productsList.add(p);
    return productsList;

}


}
