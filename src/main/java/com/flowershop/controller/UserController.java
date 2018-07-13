package com.flowershop.controller;

import com.flowershop.domain.Basket;
import com.flowershop.domain.User;
import com.flowershop.exception.UserNotFoundException;
import com.flowershop.repository.BasketRepository;
import com.flowershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BasketRepository basketRepository;

    @GetMapping(value = "/all")
    public Collection<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<Void> registration(@RequestBody @Valid User user) {
        user.setBasket(new Basket());
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable int id) throws UserNotFoundException {
        return userService.findUserById(id).orElseThrow(UserNotFoundException::new);
    }
}
