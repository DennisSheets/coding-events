package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    // place to store the events
    private static  final Map<Integer, Event> events = new HashMap<>();

    // add an event
    public static void add(Event event){
        events.put(event.getId(),event);
    }

    // get a single event
    public static Event getId(int id) {
        return events.get(id);
    }

    // get all events
    public static Collection<Event> getAll(){
        return events.values();
    }

    // remove an event
    public static void remove(int id){
        events.remove(id);
    }


}
