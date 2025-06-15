package com.codewithmosh.store.controllers;
import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@RestController
@AllArgsConstructor
@RequestMapping("/users")//used at the class level to define a common prefix for the entire controller.
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

//    @RequestMapping("/users")
//    //method: GET, POST, PUT, DELETE

@GetMapping
public Iterable<UserDto> getAllUsers(
       @RequestParam (required = false, defaultValue = "", name = "sort")String sortBy
){
    if (!Set.of("name", "email").contains(sortBy))
        sortBy = "name";

    return userRepository.findAll(Sort.by(sortBy))
            .stream()
            .map(userMapper::toDto)
            .toList();
}

    //get one customer's info
    @GetMapping("/{id}" )
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) { //ResponseEntity returns different response
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(userMapper.toDto(user));
    }
}