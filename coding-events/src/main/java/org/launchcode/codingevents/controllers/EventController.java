package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping ("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("title","All Events"); // updated title from create events to all events.   -- model binding branch
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping ("create")
    public String displayCreateEventsForm(Model model){
        model.addAttribute("title","Create Events"); // added Model  model.att    Create Events title
        return "events/create";
    }

    @PostMapping ("create")
    public String processCreateEvent(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping ("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";
    }

    @PostMapping ("delete")
    public String processEventDelete(@RequestParam (required = false) int[] eventIds) {
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping ("/edit/{eventId}")
        public String displayEditForm(Model model, @PathVariable int eventId) {
        Event event = EventData.getId(eventId);
        model.addAttribute("title","Edit Event " + eventId + "=ID");
        model.addAttribute("event",event);

        return "events/edit";
    }

    @PostMapping ("edit") // This location does not seem to exist - base on the form action  <form method="post" action="@{/events/edit}">
    public String processEditForm(int eventId, String name, String description) {
        Event event = EventData.getId(eventId);
        event.setName(name);
        event.setDescription(description);
        return "redirect:";
    }




}
