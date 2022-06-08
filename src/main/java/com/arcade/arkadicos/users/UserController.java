package com.arcade.arkadicos.users;

import com.arcade.arkadicos.products.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://127.0.0.1:8080")
public class UserController {


    @GetMapping("/api/users")

    public List<User> getUsers(){
        List<User> usersList = new ArrayList<>();
        User u = new User(
                "jesus",
                "jesusod@hotmail.com",
                "1234"

        );
        usersList.add(u);
        return usersList;
    }

    @PostMapping("/api/users/create")
    public User user(@RequestBody User u){
        return u;
    }

}
