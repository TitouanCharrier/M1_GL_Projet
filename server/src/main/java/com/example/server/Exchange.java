package com.example.server;

import java.util.Date;
import java.util.List;

public class Exchange {
    private String id;
    private Date date;
    private String status;
    private Date creationDate;
    private String user1;
    private String user2;
    
    private Listing subjectListing; 

    public boolean send() {
        return false;
    }

    public boolean accept() {
        return false;
    }

    public boolean refuse() {
        return false;
    }

    // Getter et Setter pour 'id'
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter et Setter pour 'desiredExchangeDate'
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Listing getSubjectListing() {
        return subjectListing;
    }

    public void setSubjectListing(Listing subjectListing) {
        this.subjectListing = subjectListing;
    }

    public String getUser1() {
        return this.user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return this.user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }





}
