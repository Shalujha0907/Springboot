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

@RestController
@RequestMapping(path = "/api/testController1")
public class TestController1 {

    @Autowired
    User user;

    @Autowired
    Student student;

    public TestController1(User user, Student student) {
        System.out.println("TestController1 instance initialization");
        this.user = user;
        this.student = student;
    }

    @PostConstruct
    public void init() {
        System.out.println("TestController1 obj hashcode: " + this.hashCode() + " , Users obj hashcode" + user.hashCode() + " and Student obj hashcode:- " + student.hashCode());
    }

    @GetMapping(path = "/fetchUser")
    public ResponseEntity<String> userDetails() {
        System.out.println("Fetch User api invoked");

        return ResponseEntity.status(HttpStatus.OK).body("Hello world from TestController1!!");
    }
}
