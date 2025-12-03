package com.exemple.server;

import java.util.Date;
import java.util.List;

public class Notification {
    // Attributs
    private String id;
    private String type;
    private String content;
    private boolean isRead;
    private Date creationDate;
    
    // Relations (pour la clarté)
    private User recipient;

    // Constructeur, Getters et Setters (omis pour la concision)
}
