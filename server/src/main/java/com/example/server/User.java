package com.example.server;

import java.util.Date;
import java.util.List;

public class User {

    private String id;
    private String email;
    private String name;
    private String location;
    private String password;
    private String profilePhoto;
    private String biography;
    private String phoneNumberVerified;
    private int averageReputation;

    private List<Listing> createdListings;
    private List<Resource> createdResources;
    private List<Exchange> requestedExchanges;
    private List<Review> sentReviews;
    private List<Message> sentMessages;
    private List<Notification> receivedNotifications;
    
    public boolean register() {
        return false;
    }

    public boolean login() {
        return false;
    }

    public void manageProfile() {
    }
}
