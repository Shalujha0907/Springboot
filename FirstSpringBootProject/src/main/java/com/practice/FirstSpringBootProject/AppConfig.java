package com.practice.FirstSpringBootProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    public User createUserBean() {
//        System.out.println("Hello");
        return new User("defaultName", "defaultEmail.com", new Order());
    }

    @Bean
    public User createAnotherBean() {
//        System.out.println("Hello from other Bean");
        return new User("anotherName", "anotherEmail.com", new Invoice());
    }

}
