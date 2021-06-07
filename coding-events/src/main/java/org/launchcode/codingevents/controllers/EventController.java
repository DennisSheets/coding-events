package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping ("events")
public class EventController {

    // findAll, save, findById

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllEvents(@RequestParam(required = false)Integer categoryId, Model model){
        if(categoryId == null) {
            model.addAttribute("title", "All Events");
            //model.addAttribute("events", EventData.getAll());
            model.addAttribute("events", eventRepository.findAll());
        }else {
            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Catefory ID: " + categoryId);
            } else {
                EventCategory category = result.get();
                model.addAttribute("title", "Events in category: " + category.getName());
                model.addAttribute("events", category.getEvents());
            }
        }
            return "events/index";

    }


    @GetMapping ("create")
    public String displayCreateEventsForm(Model model){
        model.addAttribute("title","Create Events");
        model.addAttribute( new Event());
        //model.addAttribute("types", EventType.values());
        model.addAttribute("categories",eventCategoryRepository.findAll());
        return "events/create";
    }

    @PostMapping ("create")

    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Events");
            return "events/create";
        }
        //EventData.add(newEvent);
        eventRepository.save(newEvent);
        return "redirect: ";
    }


    @GetMapping ("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
       //model.addAttribute("events",EventData.getAll());
        model.addAttribute("events",eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping ("delete")
    public String processEventDelete(@RequestParam (required = false) int[] eventIds) {
        if(eventIds != null) {
            for (int id : eventIds) {
                //EventData.remove(id);
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
