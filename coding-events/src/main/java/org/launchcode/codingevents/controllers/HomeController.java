package org.launchcode.codingevents.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping
    public String title(Model model){
        model.addAttribute("title","index");
        return "index";
    }
}
