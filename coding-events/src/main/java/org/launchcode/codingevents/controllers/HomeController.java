package org.launchcode.codingevents.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping
    public String title(){
        return "index";
    }
}
