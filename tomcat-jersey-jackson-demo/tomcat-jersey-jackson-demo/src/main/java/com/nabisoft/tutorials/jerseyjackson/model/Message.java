package com.nabisoft.tutorials.jerseyjackson.model;

import java.util.Date;

//@XmlRootElement       //only needed if we also want to generate XML
public class Message {
    
    private String firstName;
    
    private String lastName;
    
    private Date date;
    
    private String text;
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
