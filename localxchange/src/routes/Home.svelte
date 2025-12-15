<script lang="ts">
    import Grid from '/src/lib/Grid.svelte';
    import ResourceCard from '/src/lib/Resource.svelte';
    import ExchangeCard from '/src/lib/Exchange.svelte';
    import SearchBar from '/src/lib/SearchBar.svelte';
    import { tick } from 'svelte'; 

    let resources: any[] | undefined;
    let filteredResources: any[] | undefined;
    
    fetch('https://78.114.8.86:8080/resources')  
        .then(response => {
            if (!response.ok) {
                throw new Error('Erreur HTTP ' + response.status);
            }
            return response.json();  
        })
        .then(async data => { 
            resources = data;
            console.log(resources);  
            
            await tick(); 
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des données :', error);
            resources = []; 
        });

    $: if (resources && filteredResources === undefined) {
        filteredResources = resources;
    }
</script>

<SearchBar 
    bind:filteredResources
    items={resources}
    key="title"
/>

<Grid gridData={filteredResources} /> 

<div class="card-list">
    {#each filteredResources as resource (resource.id)}
        <ResourceCard
            id={resource.id}
            title={resource.title}
            description={resource.description}
            category={resource.category}
            price={resource.price}
            pricePerHour={resource.pricePerHour}
            creationDate={resource.creationDate}
            type={resource.type}
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
        width: 100%;
    }
</style>
