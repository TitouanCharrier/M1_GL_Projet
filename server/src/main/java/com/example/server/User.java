package com.exemple.server;

import java.util.Date;
import java.util.List;

public class User {
    // Attributs
    private String id;
    private String email;
    private String name;
    private String location;
    private String password;
    private String profilePhoto;
    private String biography;
    private String phoneNumberVerified;
    private int averageReputation;

    // Relations (Représentées par des listes pour les relations 1-*)
    private List<Listing> createdListings;
    private List<Resource> createdResources;
    private List<Exchange> requestedExchanges;
    private List<Review> sentReviews;
    private List<Message> sentMessages;
    private List<Notification> receivedNotifications;
    
    // Constructeur (omis pour la concision)
    
    // Getters et Setters (omis pour la concision)

    // Méthodes
    public boolean register() {
        // Logique d'enregistrement
        return false;
    }

    public boolean login() {
        // Logique de connexion
        return false;
    }

    public void manageProfile() {
        // Logique de gestion du profil
    }
}
