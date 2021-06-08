package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends AbstractEntity{

    @Size(min=1, max=25,message = "must be between 1 and 25 characters")
    @NotBlank(message="name is required")
    private String name;

    //@ManyToMany(mappedBy = "tags")
    //private final List<Event> events = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {}

    public String getDisplayName() {
        return "#" + name + " ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Event> getEvents() {
//        return events;
//    }
}
