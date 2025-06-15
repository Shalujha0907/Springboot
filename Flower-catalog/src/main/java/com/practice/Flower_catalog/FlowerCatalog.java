package com.practice.Flower_catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlowerCatalog {

    @GetMapping("/")
    public Object serverMainPage() {
        return "index";
    }

    @GetMapping("/rose")
    public  Object serveAnotherPage() {
        return "rose";
    }
}
