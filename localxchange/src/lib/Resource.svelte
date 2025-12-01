<script>
    import { createEventDispatcher } from 'svelte';

    export let id;
    export let title;
    export let description;
    export let category = 'Général'; 
    export let price = null; 
    export let pricePerHour = null; 
    export let creationDate;
    export let type = 'Resource'; 
    const dispatch = createEventDispatcher();

    function getPriceLabel() {
        if (pricePerHour !== null) {
            // C'est un Skill
            return `${pricePerHour.toFixed(2)} € / heure`;
        }
        if (price !== null) {
            // C'est un Item
            return `${price.toFixed(2)} €`;
        }
        return 'Non monétisable';
    }


</script>

<article class="resource-card {type.toLowerCase()}">
    <header class="card-header">
        <h3>{title}</h3>
        <span class="type-tag">{type}</span>
    </header>

    <div class="card-body">
        <p class="description">
            {description.length > 100 ? description.substring(0, 100) + '...' : description}
        </p>
        
        <div class="details-grid">
            {#if price !== null || pricePerHour !== null}
                <div class="detail-item">
                    <span class="label">Prix :</span>
                    <span class="value price-value">{getPriceLabel()}</span>
                </div>
            {/if}
            
            <div class="detail-item">
                <span class="label">Catégorie :</span>
                <span class="value">{category}</span>
            </div>

            <div class="detail-item">
                <span class="label">Création :</span>
                <span class="value">{new Date(creationDate).toLocaleDateString()}</span>
            </div>
        </div>
    </div>

    <footer class="card-footer">
        <button>Ajouter au panier</button>
        <span class="id-info">ID: {id}</span>
    </footer>
</article>

<style>
    .resource-card {
        background-color: #2c3e50;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        margin: 15px;
        transition: transform 0.2s, box-shadow 0.2s;
        max-width: 350px;
        min-width: 300px;
        font-family: sans-serif;
    }

    .resource-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
    }
    

    .card-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 15px;
        background-color: #2c3e50;
        border-bottom: 2px solid var(--main-color, #007bff);
    }

    .card-header h3 {
        margin: 0;
        font-size: 1.3em;
        color: #fff;
    }
    .card-footer {
        padding: 15px;
        border-top: 1px solid #eee;
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #2c3e50;
    }

    .type-tag {
        padding: 4px 8px;
        border-radius: 12px;
        font-size: 0.8em;
        font-weight: bold;
        color: white;
        background-color: var(--main-color, #007bff);
    }

    .card-body {
        padding: 15px;
    }

    .description {
        color: #fff;
        font-size: 0.9em;
        line-height: 1.4;
        margin-bottom: 15px;
    }

    .details-grid {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 10px;
        border-top: 1px dashed #eee;
        padding-top: 10px;
    }

    .detail-item {
        display: flex;
        flex-direction: column;
    }

    .label {
        font-size: 0.8em;
        color: #fff;
        font-weight: 500;
        margin-bottom: 3px;
    }

    .value {
        font-size: 0.9em;
        font-weight: bold;
        color: #fff;
    }

    .price-value {
        color: #28a745;
    }
    


    .card-footer button {
        padding: 8px 15px;
        background-color: var(--main-color, #007bff);
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.2s;
    }

    .card-footer button:hover {
        background-color: var(--dark-color, #0056b3);
    }

    .id-info {
        font-size: 0.7em;
        color: #ccc;
    }
    
    .item {
        --main-color: #e44d26; 
        --dark-color: #b3391b;
    }
    .skill {
        --main-color: #28a745; 
        --dark-color: #1e7e34;
    }
</style>
