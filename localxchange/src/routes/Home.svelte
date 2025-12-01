<script lang="ts">
  import Grid from '/src/lib/Grid.svelte';
  import ResourceCard from '/src/lib/Resource.svelte';
  import ExchangeCard from '/src/lib/Exchange.svelte';

  const resources = [
          {
              id: 'SK-001',
              title: 'Test service',
              description: 'description du service',
              category: 'category',
              pricePerHour: 75.00,
              creationDate: new Date('2025-11-20'),
              type: 'Skill'
          },
          {
              id: 'IT-001',
              title: 'test item',
              description: 'description de litem',
              category: 'category',
              price: 12.00, 
              creationDate: new Date('2025-10-15'),
              type: 'Item'
          }
      ];


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
