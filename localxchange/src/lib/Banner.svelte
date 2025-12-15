<script lang="ts">
    // --- NOUVEAU : Importation du store de localisation de svelte-spa-router ---
    import { push, location } from 'svelte-spa-router'; 
    import { isConnected, handleLogout } from '../lib/stores/authStore'; 

    const navLinks = [
        { name: 'Marché', href: '/', requiresAuth: false },
        { name: 'Créer une Annonce', href: '/transactions', requiresAuth: true },
        { name: 'Connexion', href: '/profile', requiresAuth: false },
        { name: 'Mon Profile', href: '/profile-connected', requiresAuth: true }, 
        { name: 'Historique', href: '/echanges', requiresAuth: true },
        { name: 'Messagerie', href: '/message', requiresAuth: true }
    ];

    function navigate(href: string) {
        push(href);
    }

    $: filteredLinks = navLinks.filter(link => {
        if (!link.requiresAuth) {
            // Mais si l'utilisateur est connecté, on exclut le lien 'Connexion'.
            return !$isConnected || (link.name !== 'Connexion');
        } 
        if (link.requiresAuth) {
            return $isConnected;
        }
        
        return false;
    });
    
    // Règle spéciale pour lier le bouton Mon Profile avec l'URL /profile ou /profile-connected
    function isActive(href: string): boolean {
        // La variable $location contient le chemin d'URL actuel
        
        // Cas spécial : /profile et /profile-connected pointent vers la même activation visuelle
        if (href.includes('/profile') && $location.includes('/profile')) {
            return true;
        }

        // Cas général : Correspondance exacte du chemin (ex: /message == /message)
        return $location === href;
    }
</script>

<nav class="sidebar">
    <div class="sidebar-brand">
        <a on:click={() => navigate('/')}>Local X Change</a>
    </div>

    <div class="sidebar-links">
        {#each filteredLinks as link}
            <button 
                on:click={() => navigate(link.href)} 
                class="nav-button"
                class:active={isActive(link.href)} 
            >
                {link.name}
            </button>
        {/each}
    </div>

    {#if $isConnected}
        <button on:click={handleLogout} class="nav-button logout-btn">
            Déconnexion
        </button>
    {/if}
    
    <div class="sidebar-footer">
        <small>© 2025</small>
    </div>
</nav>

<style>
    .sidebar {
        /* Propriétés clés pour le rendre vertical et plein écran */
        position: fixed; 
        top: 0;
        left: 0;
        width: 15em; 
        height: 100vh; 
        
        /* Disposition interne */
        display: flex;
        flex-direction: column; 
        justify-content: space-between; 
        align-items: center; 
        
        background-color: #2c3e50; 
        padding: 20px 0;
        box-shadow: 2px 0 8px rgba(0, 0, 0, 0.2);
        color: white;
        font-family: sans-serif;
        z-index: 1000; 
        overflow: hidden;
    }
    
    .sidebar-brand {
        padding-bottom: 20px;
        border-bottom: 1px solid rgba(255, 255, 255, 0.1);
        width: 80%;
        text-align: center;
        margin-bottom: 10px; /* Ajout d'une petite marge */
    }

    .sidebar-brand a {
        color: #42b983;
        font-size: 1.5em;
        font-weight: bold;
        text-decoration: none;
        cursor: pointer;
    }

    .sidebar-links {
        display: flex;
        flex-direction: column; 
        width: 100%;
        flex-grow: 1; 
        padding: 10px 0;
        align-items: center;
    }

    .nav-button {
        background-color: transparent;
        border: none;
        color: white;
        padding: 15px 20px;
        font-size: 1em;
        cursor: pointer;
        text-align: left;
        width: 90%; 
        margin: 2px 0; 
        border-radius: 4px;
        transition: background-color 0.3s ease, color 0.3s ease; /* Ajout de la transition couleur */
    }
    
    .nav-button.active {
        background-color: #42b983; 
        color: #eee; 
        font-weight: bold;
        box-shadow: inset 3px 0 0 #42b983; 
        margin-right: -2em;
    }

    
    .nav-button:hover:not(.active) {
        background-color: #556d86; 
    }
    .nav-button.active:hover {
        
        background-color: #42b983; 
    }
    
    .logout-btn {
        background-color: #c0392b; 
        width: 80%;
        margin-bottom: 20px;
        font-weight: bold;
    }
    
    .logout-btn:hover {
        background-color: #e74c3c;
        color: white;
    }
    
    .sidebar-footer {
        padding-top: 20px;
        color: rgba(255, 255, 255, 0.5);
        text-align: center;
    }
</style>
