package com.practice.Scope;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Student {

    @Autowired
    User user;

    public Student() {
        System.out.println("Student instance initialized");
    }

    @PostConstruct
    public void init() {
        System.out.println("Student obj hashcode: " + this.hashCode() + " and user obj hashcode :- " + user.hashCode());
    }
}
