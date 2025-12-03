<script lang="ts">
  import Grid from '/src/lib/Grid.svelte';
  import ResourceCard from '/src/lib/Resource.svelte';
  import ExchangeCard from '/src/lib/Exchange.svelte';

  let resources;
 
 fetch('http://localhost:8080/resources')  
    .then(response => {
        if (!response.ok) {
            throw new Error('Erreur HTTP ' + response.status);
        }
        return response.json();  
    })
    .then(data => {
        resources = data;
        console.log(resources);  
    })
    .catch(error => {
        console.error('Erreur lors de la récupération des données :', error);
    });


</script>

<Grid gridDate={resources} /> 

<div class="card-list">
    {#each resources as resource (resource.id)}
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
    }
</style>
