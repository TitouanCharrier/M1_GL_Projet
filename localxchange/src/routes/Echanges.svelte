<script lang="ts">
    import Grid from '/src/lib/Grid.svelte';
    import ExchangeCard from '/src/lib/Exchange.svelte';
    import SearchBar from '/src/lib/SearchBar.svelte';
    import { tick } from 'svelte'; 

    let exchanges;
    let filteredResources;
    
    fetch('https://78.114.8.86:8080/exchanges')  
        .then(response => {
            if (!response.ok) {
                throw new Error('Erreur HTTP ' + response.status);
            }
            return response.json();  
        })
        .then(async data => { 
            exchanges = data;
            console.log(exchanges); 
            
            await tick(); 
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des données :', error);
        });

    $: if (exchanges && filteredResources === undefined) {
        filteredResources = exchanges;
    }
</script>

<SearchBar 
    bind:filteredResources
    items={exchanges}
    key="subjectTitle"
/>

<Grid gridData={filteredResources} /> 

<div class="card-list">
    {#each filteredResources as exchange (exchange.id)}
        <ExchangeCard
            id={exchange.id}
            date={exchange.date}
            status={exchange.status}
            user1={exchange.user1}
            user2={exchange.user2}
            res1={exchange.res1}
            res2={exchange.res2}
            subjectTitle={exchange.subjectTitle}
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
