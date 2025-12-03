package com.example.server;

import java.util.Date;
import java.util.List;

public class Exchange {
    private String id;
    private Date desiredExchangeDate;
    private String status;
    private Date creationDate;
    
    private Listing subjectListing; 
    private List<User> participants; 

    public boolean send() {
        return false;
    }

    public boolean accept() {
        return false;
    }

    public boolean refuse() {
        return false;
    }
}
