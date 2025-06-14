package com.practice.FirstSpringBootProject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/")
public class SampleRestController {

    @InitBinder
    protected void initBinder(@org.jetbrains.annotations.NotNull DataBinder binder) {
        binder.registerCustomEditor(String.class, "firstName", new FirstNamePropertyEditor());
        binder.registerCustomEditor(String.class, "lastName", new FirstNamePropertyEditor());

    }


    @GetMapping(path = "/fetchUser{fatherName}{motherName}")
    public ResponseEntity<String> getUserDetails(@RequestParam(value = "firstName") String firstName,
                                         @RequestParam(value = "lastName", required = false) String lastName,
                                         @RequestParam(value = "age", required = false) Integer age,
                                         @PathVariable(value = "fatherName", required = false) String fatherName,
                                         @PathVariable(value = "motherName", required = false) String motherName) {
        String output = "Fetched Users details of " + firstName + " " + lastName + " with age of " + age + " and Father name and Mother Name are " + fatherName + " " + motherName + " respectively.";
        return ResponseEntity.status(HttpStatus.OK).body(output);

    }

//    @PostMapping(path = "/saveUser")
//    public String getUserDetails(@RequestBody User user) {
//        return  "User Created " + user.username + ":" + user.email;
//
//    }
}
