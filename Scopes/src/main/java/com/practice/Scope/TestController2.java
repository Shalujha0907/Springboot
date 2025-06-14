package com.practice.Scope;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping(path = "/api/testController2")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TestController2 {

//    @Autowired
    User user;

    public TestController2(User user) {
        System.out.println("TestController2 instance initialization");
        this.user = user;
    }

//    @PostConstruct
    public void init() {
        System.out.println("TestController2 obj hashcode: " + this.hashCode() + "Users obj hashcode" + user.hashCode());
    }

//    @GetMapping(path = "/fetchUser")
    public ResponseEntity<String> userDetails() {
        System.out.println("Fetch User api invoked");

        return ResponseEntity.status(HttpStatus.OK).body("Hello world from TestController2!!");
    }
}
