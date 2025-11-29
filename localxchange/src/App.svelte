<script lang="ts">
  import Router from 'svelte-spa-router';
  import Banner from './lib/Banner.svelte';
  import Profile from './routes/Profile.svelte';
  import Annonces from './routes/Annonces.svelte';
  import Echanges from './routes/Echanges.svelte';
  import Transactions from './routes/Transactions.svelte';
  import Home from './routes/Home.svelte'; 
  import NotFound from './routes/NotFound.svelte';

  const routes = {
    '/': Home, 
    '/profile': Profile,
    '/annonces': Annonces,
    '/echanges': Echanges,
    '/transactions': Transactions,
    '*': NotFound,
  };
</script>

  <main>
    <div class="banner">
      <Banner />
    </div>
    <div class="router">
    <Router {routes} />
    </div>
  </main>

<style>

main {
    /* 1. Mettre toute la page en Flexbox pour aligner Sidebar et Contenu */
    display: flex;
    /* 2. S'assurer que ça prend toute la hauteur de l'écran */
    min-height: 100vh;
    width: 100%;
    /* 3. Retirer les marges par défaut du body si elles existent (voir point 3) */
  }

  .logo {
    height: 6em;
    padding: 1.5em;
    will-change: filter;
    transition: filter 300ms;
  }
  .logo:hover {
    filter: drop-shadow(0 0 2em #646cffaa);
  }
  .logo.svelte:hover {
    filter: drop-shadow(0 0 2em #ff3e00aa);
  }
  .read-the-docs {
    color: #888;
  }
</style>
