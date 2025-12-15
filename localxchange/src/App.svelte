<script lang="ts">
  import Router from 'svelte-spa-router';
  import Banner from './lib/Banner.svelte';
  import Profile from './routes/Profile.svelte';
  import Annonces from './routes/Annonces.svelte';
  import Echanges from './routes/Echanges.svelte';
  import Transactions from './routes/Transactions.svelte';
  import Home from './routes/Home.svelte'; 
  import NotFound from './routes/NotFound.svelte';
  import ProfileConnected from './routes/Profile-connected.svelte';

  const routes = {
    '/': Home, 
    '/profile': Profile,
    '/annonces': Annonces,
    '/echanges': Echanges,
    '/transactions': Transactions,
    '/profile-connected': ProfileConnected,
    '*': NotFound,
  };
</script>

  <main>
    <Banner />
    <div class="router">
    <Router {routes} />
    </div>
  </main>

<style>

main {
    display: flex;
    min-height: 100vh;
    width: 100%;
  }

  .router {
  flex-grow: 1;
  width: 100%;
  }
  
.banner {
    width: 10em; 
    flex-shrink: 0; 
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
