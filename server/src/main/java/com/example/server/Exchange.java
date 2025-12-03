package com.exemple.server;

import java.util.Date;
import java.util.List;

public class Exchange {
    // Attributs
    private String id;
    private Date desiredExchangeDate;
    private String status;
    private Date creationDate;
    
    // Relations
    private Listing subjectListing; // Relation 1 Exchange - 1 Listing
    private List<User> participants; // Relation 1 Exchange - 1..2 User (participants)

    // Constructeur, Getters et Setters (omis pour la concision)

    // Méthodes
    public boolean send() {
        // Logique d'envoi
        return false;
    }

    public boolean accept() {
        // Logique d'acceptation
        return false;
    }

    public boolean refuse() {
        // Logique de refus
        return false;
    }
}
