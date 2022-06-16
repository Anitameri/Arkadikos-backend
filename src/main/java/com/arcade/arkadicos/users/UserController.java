package com.arcade.arkadicos.users;

import com.arcade.arkadicos.products.Product;
import com.arcade.arkadicos.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

    @Autowired
    UserService service;


    @GetMapping("/api/users")

    public List<User> getall(){
        return service.getAllUsers();

    }

    @PostMapping("/api/users/create")
    public User user(@RequestBody User u){
        u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
        return service.create(u);
    }

}
