package com.exemple.server;  // correction du package

import java.time.LocalDateTime;

public class Message {
    // Attributs
    private String id;
    private String content;
    private LocalDateTime timestamp; // type moderne
    
    // Relations
    private User sender;
    private User receiver;

    // Constructeur, Getters et Setters (omis pour la concision)
}

