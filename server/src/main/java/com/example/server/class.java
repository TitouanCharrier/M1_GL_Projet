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

// Classe abstraite pour l'héritage
public abstract class Resource {
    // Attributs
    private String id;
    private String title;
    private String description;
    private Date creationDate;

    // Constructeur, Getters et Setters (omis pour la concision)
}

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
public class Item extends Resource {
    // Attributs spécifiques
    private double price;

    // Constructeur, Getters et Setters (omis pour la concision)

    // Méthodes
    public boolean create() {
        // Logique de création
        return false;
    }

    public List<Item> browse() {
        // Logique de navigation
        return null;
    }

    public List<Item> search() {
        // Logique de recherche
        return null;
    }
}

// ---

// Skill hérite de Resource
public class Skill extends Resource {
    // Attributs spécifiques
    private double pricePerHour;

    // Constructeur, Getters et Setters (omis pour la concision)

    // Méthodes
    public boolean create() {
        // Logique de création
        return false;
    }

    public List<Skill> browse() {
        // Logique de navigation
        return null;
    }

    public List<Skill> search() {
        // Logique de recherche
        return null;
    }
}

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

public class Message {
    // Attributs
    private String id;
    private String content;
    private Date timestamp;
    
    // Relations (pour la clarté)
    private User sender;
    private User receiver;

    // Constructeur, Getters et Setters (omis pour la concision)
}

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
