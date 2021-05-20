package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping ("events")
public class EventController {

    @GetMapping
    public String makeEvents(Model model){
        List<String > events = Arrays.asList("geekChat", "Coder Monkeys", "Programming Church");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping ("create")   // lives at events/create
    public String renderCreateEventsForm(){
        return "events/create";
    }

}
