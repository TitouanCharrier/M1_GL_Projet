package com.exemple.server;

import java.util.Date;
import java.util.List;

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
