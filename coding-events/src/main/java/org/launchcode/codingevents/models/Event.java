package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @Size(min=3, max=50, message = "Name needs to be between 3 and 50 characters.")
    @NotBlank (message = "Name field must not be blank")
    private String name;

    @Size(max=500, message = "Description is too long.")
    private String description;

    @Email( message = "Invalid email. Try again.")
    @NotBlank (message = "Contact email must not be blank")
    private String contactEmail;

    @NotNull (message= "How the hell did you manage to make this null")
    @NotBlank (message=" You must provide the location for this event")
    private String location;

    @AssertTrue(message= "Events must require attendee registration")
    private boolean regRequired;

    @Min ( value= 1, message="Your event must have at least 1 attendee")
    private int numAttendees;

    @Max (value=500, message="That's too rich for this platform. Event cost can not exceed $500")
    private int attendanceCost;

    public Event(String name, String description,String contactEmail,String location,boolean regRequired,int numAttendees, int attendanceCost) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.regRequired = regRequired;
        this.numAttendees = numAttendees;
        this.attendanceCost = attendanceCost;

    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegRequired() {
        return regRequired;
    }

    public void setRegRequired(boolean regRequired) {
        this.regRequired = regRequired;
    }

    public int getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(int numAttendees) {
        this.numAttendees = numAttendees;
    }

    public int getAttendanceCost() {
        return attendanceCost;
    }

    public void setAttendanceCost(int attendanceCost) {
        this.attendanceCost = attendanceCost;
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
