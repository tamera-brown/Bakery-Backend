package com.tp.bakery.controller;

import com.tp.bakery.model.Order;
import com.tp.bakery.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    BakeryService service;

    @GetMapping("/orders")
    List<Order> getAllOrders(){
        return service.getAllOrders();
    }
}
