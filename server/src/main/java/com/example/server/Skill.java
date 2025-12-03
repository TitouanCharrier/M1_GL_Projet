package com.exemple.server;

import java.util.Date;
import java.util.List;

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
