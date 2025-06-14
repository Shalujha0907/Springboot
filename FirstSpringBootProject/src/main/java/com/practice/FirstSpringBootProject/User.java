package com.practice.FirstSpringBootProject;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class User {

    String userName;
    String email;
    Order order;
    Invoice invoice;


    public User(String userName, String email, Order order) {
        this.userName = userName;
//        this.email = email;
//        this.order = order;
//        System.out.println("Initializing Order");
    }

    @Autowired
    public User(String userName, String email,Invoice invoice) {
        this.userName = userName;
        this.email = email;
        this.invoice = invoice;
    }

    public String getUsername() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername() {
        this.userName = userName;
    }

    public void setEmail() {
        this.email = email;
    }
}
