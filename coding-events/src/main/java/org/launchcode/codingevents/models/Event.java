package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity //Entity & Persistent Class  --- event objects can be stored outside the pro in a db
public class Event extends AbstractEntity{

    @Size(min=3, max=50, message = "Name needs to be between 3 and 50 characters.")
    @NotBlank (message = "Name field must not be blank")
    private String name;

    @Size(max=500, message = "Description is too long.")
    private String description;


    @Email( message = "Invalid email. Try again.")
    @NotBlank (message = "Contact email must not be blank")
    private String contactEmail;

    //private EventType type;

    @ManyToOne
    @NotNull (message="Category is required")
    private EventCategory eventCategory;


    public Event(String name, String description,String contactEmail,EventCategory eventCategory) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventCategory = eventCategory;

    }

    public Event() { }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }
}
