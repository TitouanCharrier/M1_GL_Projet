<script lang="ts">
  import Grid from '/src/lib/Grid.svelte';
  import ExchangeCard from '/src/lib/Exchange.svelte';

  let exchanges;
 
 fetch('http://localhost:8080/exchanges')  
    .then(response => {
        if (!response.ok) {
            throw new Error('Erreur HTTP ' + response.status);
        }
        return response.json();  
    })
    .then(data => {
        exchanges = data;
        console.log(resources);  
    })
    .catch(error => {
        console.error('Erreur lors de la récupération des données :', error);
    });



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
