package com.example.server;

import java.util.Date;
import java.util.List;

public class Listing {
    private String id;
    private String title;
    private String description;
    private String category;
    private List<String> images;
    private String availability;
    private Date creationDate;
    
    private User creator; 
    private Resource subjectResource; 

    public boolean create() {
        return false;
    }

    public List<Listing> browse() {
        return null;
    }

    public List<Listing> search() {
        return null;
    }
}
