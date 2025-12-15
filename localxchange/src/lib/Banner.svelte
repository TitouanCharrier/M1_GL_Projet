<script lang="ts">
    import { push } from 'svelte-spa-router';
    import { isConnected, handleLogout } from '../lib/stores/authStore'; 

    const navLinks = [
        { name: 'Marché', href: '/', requiresAuth: false },
        { name: 'Créer une Annonce', href: '/transactions', requiresAuth: true },
        { name: 'Connexion', href: '/profile', requiresAuth: false },
        { name: 'Mon Profile', href: '/profile-connected', requiresAuth: true }, 
        { name: 'Mes Annonces', href: '/annonces', requiresAuth: true },
        { name: 'Historique', href: '/echanges', requiresAuth: true }
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
</script>

<nav class="sidebar">
    <div class="sidebar-brand">
        <a on:click={() => navigate('/')}>Local X Change</a>
    </div>

    <div class="sidebar-links">
        {#each filteredLinks as link}
            <button on:click={() => navigate(link.href)} class="nav-button">
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
    /* -------------------
       Structure Verticale et Fixe
       ------------------- */
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
    }
    
    /* -------------------
       Marque et Liens
       ------------------- */
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
        margin: 2px 0; /* Espacement réduit */
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }

    .nav-button:hover {
        background-color: #42b983; 
        color: #2c3e50;
    }
    
    /* Style spécifique pour le bouton Déconnexion */
    .logout-btn {
        background-color: #c0392b; /* Rouge foncé */
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
