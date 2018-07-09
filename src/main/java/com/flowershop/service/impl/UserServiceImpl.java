package com.flowershop.service.impl;

import com.flowershop.domain.Basket;
import com.flowershop.domain.Flower;
import com.flowershop.domain.User;
import com.flowershop.repository.BasketRepository;
import com.flowershop.repository.UserRepository;
import com.flowershop.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BasketRepository basketRepository;

    public UserServiceImpl(UserRepository userRepository, BasketRepository basketRepository) {
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
    }

    @Override
    public Collection<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<Basket> findBasketById(int id) {
        return basketRepository.findById(id);
    }

    @Override
    public List<Flower> getAllFlowersInBasket(Basket basket) {
        return basketRepository.findAllByFlowersInBasket(basket);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional
                .ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
