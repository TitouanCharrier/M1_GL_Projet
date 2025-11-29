<script lang="ts">
  // 1. Importer la fonction 'push' du routeur
  import { push } from 'svelte-spa-router'; 

  const navLinks = [
    { name: 'Mon Profil', href: '/profile' },
    { name: 'Mes Annonces', href: '/annonces' },
    { name: 'Mes Échanges', href: '/echanges' },
    { name: 'Mes Transactions', href: '/transactions' }
  ];

  function navigate(href: string) {
    // 2. Utiliser push(href) au lieu de window.location.href
    push(href); 
  }
</script>

<nav class="sidebar">
  <div class="sidebar-brand">
    <a href="/">Local X Change</a>
  </div>

  <div class="sidebar-links">
    {#each navLinks as link}
      <button on:click={() => navigate(link.href)} class="nav-button">
        {link.name}
      </button>
    {/each}
  </div>
  
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
    position: fixed; /* Reste en place lors du défilement */
    top: 0;
    left: 0;
    width: 250px; /* Largeur de la barre latérale */
    height: 100vh; /* Prend 100% de la hauteur de la fenêtre (Viewport Height) */
    
    /* Disposition interne */
    display: flex;
    flex-direction: column; /* Organise le contenu verticalement */
    justify-content: space-between; /* Place le footer en bas */
    align-items: center; /* Centre le contenu horizontalement */
    
    background-color: #2c3e50; /* Couleur de fond sombre */
    padding: 20px 0;
    box-shadow: 2px 0 8px rgba(0, 0, 0, 0.2);
    color: white;
    font-family: sans-serif;
    z-index: 1000; /* Assurez-vous qu'elle est au-dessus du contenu */
  }
  
  /* -------------------
     Marque et Liens
     ------------------- */
  .sidebar-brand {
    padding-bottom: 20px;
    border-bottom: 1px solid rgba(255, 255, 255, 0.1);
    width: 80%;
    text-align: center;
  }

  .sidebar-brand a {
    color: #42b983;
    font-size: 1.5em;
    font-weight: bold;
    text-decoration: none;
  }

  .sidebar-links {
    display: flex;
    flex-direction: column; /* Les liens sont empilés verticalement */
    width: 100%;
    flex-grow: 1; /* Permet aux liens de prendre l'espace restant */
    padding: 20px 0;
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
    width: 80%; /* Occupe une grande partie de la largeur */
    margin: 5px 0;
    border-radius: 4px;
    transition: background-color 0.3s ease;
  }

  .nav-button:hover {
    background-color: #42b983; /* Met en évidence au survol */
    color: #2c3e50;
  }
  
  .sidebar-footer {
    padding-top: 20px;
    color: rgba(255, 255, 255, 0.5);
    text-align: center;
  }
</style>
