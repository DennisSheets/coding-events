package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping ("events")
public class EventController {
    public static int id = 0;
    public static int nextID = 3;

    //private static ArrayList<String> events =  new ArrayList<>(Arrays.asList("geekChat", "Coder Monkeys", "Programming Church"));

    private static Map<String,String> event0 = Map.of(
            "Event","Geek Party",
            "Description","It's a celebration of pocket protectors",
            "Image", "geek image",
            "Url", "geek url");

    private static Map<String,String> event1 = Map.of(
            "Event","Fun with Code",
            "Description","Entertaining ways of using JavaScript",
            "Image", "nerd image",
            "Url", "nerd url");

    private static Map<String,String> event2 = Map.of(
            "Event","Typing Fanatics",
            "Description","Not really coding, just beating the hell out our keyboards",
            "Image", "typing image",
            "Url", "typing url");

    private static List<Map> events = new ArrayList<>(Arrays.asList(event0, event1, event2));


    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping ("create")   // lives at events/create GET
    public String renderCreateEventsForm(){
        return "events/create";
    }

    @PostMapping ("create")  // lives at events/create POST
    public String createEvent(@RequestParam String eventName, String eventDescription, String eventImageUrl, String eventUrl){

        HashMap<String,String> nextID = new HashMap<>();
            nextID.put("Event",eventName);
            nextID.put("Description",eventDescription);
            nextID.put("Image", eventImageUrl);
            nextID.put("Url", eventUrl);
        //nextID++;
        return "redirect: ";
    }
}
