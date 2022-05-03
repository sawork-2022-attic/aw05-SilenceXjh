package com.micropos.carts.service;

import java.util.List;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;
import com.micropos.carts.repository.CartsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartServiceImp implements CartService {
    
    @Autowired
    private CartsRepository cartsRepository;

    @Override
    @Cacheable(value = "cartCache", key = "#cartId")
    public Cart getCart(int cartId) {
        return cartsRepository.findCart(cartId);
    }

    @Override 
    public Cart createCart() {
        return cartsRepository.createCart();
    }

    @Override
    @Cacheable(value = "cartCache", key = "'carts'")
    public List<Cart> carts() {
        return cartsRepository.allCarts();
    }

    @Override
    public Cart addItemToCart(int cartId, Item item) {
        Cart cart = getCart(cartId);
        if(cart == null) 
            return null;
        cart.addItem(item);
        return cart;
    }

    @Override
    public double getTotal(int cartId) {
        Cart cart = getCart(cartId);
        if(cart == null) {
            return 0.0;
        }
        return cart.getTotal();
    }

}