package com.exemple.server;

import java.util.Date;
import java.util.List;

public class Listing {
    // Attributs
    private String id;
    private String title;
    private String description;
    private String category;
    private List<String> images;
    private String availability;
    private Date creationDate;
    
    // Relations
    private User creator; // Relation 1 Listing - 1 User
    private Resource subjectResource; // Relation 1 Listing - 1 Resource (sells)

    // Constructeur, Getters et Setters (omis pour la concision)

    // Méthodes
    public boolean create() {
        // Logique de création
        return false;
    }

    public List<Listing> browse() {
        // Logique de navigation
        return null;
    }

    public List<Listing> search() {
        // Logique de recherche
        return null;
    }
}
