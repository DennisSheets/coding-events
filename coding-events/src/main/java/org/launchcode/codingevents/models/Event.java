package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity //Entity & Persistent Class  --- event objects can be stored outside the pro in a db
public class Event extends AbstractEntity{

    @Size(min=3, max=50, message = "Name needs to be between 3 and 50 characters.")
    @NotBlank (message = "Name field must not be blank")
    private String name;

    @OneToOne (cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull (message="Category is required")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();


    //public Event(String name, String description,String contactEmail,EventCategory eventCategory) {
    public Event(String name,EventCategory eventCategory) {
        this.name = name;
        this.eventCategory = eventCategory;

    }

    public Event() { }

    @Override
    public String toString() { return name; }

     public void addTag(Tag tag){ this.tags.add(tag); }


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

     public EventCategory getEventCategory() {return eventCategory;}

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;}

    public EventDetails getEventDetails() {return eventDetails;}

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTags() { return tags;}
}
