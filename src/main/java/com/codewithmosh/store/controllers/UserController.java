package com.codewithmosh.store.controllers;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")//used at the class level to define a common prefix for the entire controller.
public class UserController {
    private final UserRepository userRepository;

//    @RequestMapping("/users")
//    //method: GET, POST, PUT, DELETE

    @GetMapping
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    //get one customer's info
    @GetMapping("/{id}" )
    public ResponseEntity<User> getUser(@PathVariable Long id) { //ResponseEntity returns different response
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
