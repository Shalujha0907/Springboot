package com.practice.Scope;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class User {
    public User() {
        System.out.println("User instance is initialized");
    }

    @PostConstruct
    public void init() {
        System.out.println("User instance hashcode :" + this.hashCode());
    }
}
