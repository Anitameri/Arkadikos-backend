package com.arcade.arkadicos.users;

import com.arcade.arkadicos.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService
{
     private final UserRepository userRepository;

     public UserService(UserRepository userRepository){
         this.userRepository=userRepository;
     }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> all = getAllUsers();
        for(User u : all)
            if(u.getUsername().equals(username))
                return u;
        throw new UsernameNotFoundException("User Not Found: " + username);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){

        return userRepository.findById(id);

    }

    public User create(User user){
        return userRepository.save(user);
    }
}