package com.practice.FirstSpringBootProject;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Invoice {

    public Invoice() {
        System.out.println("Invoice Initialized");
    }
}
