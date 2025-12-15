// lib/stores/authStore.ts

import { writable } from 'svelte/store';
import { push } from 'svelte-spa-router';

// 1. Store pour l'état de connexion
// Initialisé à false par défaut (l'utilisateur est déconnecté au démarrage)
export const isConnected = writable(false);

/**
 * Fonction qui simule le processus de connexion.
 * Met à jour l'état du Store et effectue la redirection.
 */
export function handleLogin() {
    isConnected.set(true);
    // Après connexion, redirection vers le dashboard de profil
    console.log("On s'est connecté");
    
    push('/profile-connected');
}

/**
 * Fonction qui simule le processus de déconnexion.
 * Met à jour l'état du Store et effectue la redirection.
 */
export function handleLogout() {
    isConnected.set(false);
    // Après déconnexion, redirection vers l'accueil ou la page de connexion
    push('/');
}
