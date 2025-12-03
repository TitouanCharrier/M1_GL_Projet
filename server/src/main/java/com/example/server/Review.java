package com.exemple.server;

import java.util.Date;
import java.util.List;

public class Review {
    // Attributs
    private String id;
    private int rating; // (1-5 stars)
    private String comment;
    private Date reviewDate;
    
    // Relations (pour la clarté)
    private User sender;
    private User receiver; // (La relation "get" implicite)

    // Constructeur, Getters et Setters (omis pour la concision)
}

