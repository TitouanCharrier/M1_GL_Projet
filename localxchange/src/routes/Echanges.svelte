<script lang="ts">
  import Grid from '/src/lib/Grid.svelte';
  import ExchangeCard from '/src/lib/Exchange.svelte';

  const exchanges = [
          {
              id: 'EX-001',
              date: new Date('2025-11-20'),
              status: 'completed',
              user1: "Jérome",
              user2: "Monique",
              res1: "défibrillateur",
              res2: "laçage de chaussure"
          },
          {
              id: 'EX-002',
              date: new Date('2025-11-20'),
              status: 'completed',
              user1: "Jérome",
              user2: "Monique",
              res1: "raton laveur",
              res2: "paire de claque"
          },
      ];


</script>

<Grid gridDate={exchanges} /> 

<div class="card-list">
    {#each exchanges as exchange (exchange.id)}
        <ExchangeCard
            id={exchange.id}
            date={exchange.date}
            status={exchange.status}
            user1={exchange.user1}
            user2={exchange.user2}
            res1={exchange.res1}
            res2={exchange.res2}
        />
    {/each}
</div>

<style>
    .card-list {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center;
        padding: 20px;
    }
</style>
