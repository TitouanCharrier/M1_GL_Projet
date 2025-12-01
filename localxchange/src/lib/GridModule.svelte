<script>
    // Déclarer les props (données passées depuis le parent)
    export let content;
    export let type;
    export let value;

    // Déclaration réactive pour gérer un compteur interne (exemple)
    let counter = 0;

    function handleButtonClick() {
        counter += 1;
        console.log(`${content} cliqué !`);
    }
</script>

<div class="module {type}">
    <h4>{content}</h4>
    <p>Type: <strong>{type}</strong></p>
    
    {#if type === 'button'}
        <button on:click={handleButtonClick}>
            {value} ({counter})
        </button>
    {:else if type === 'header'}
        <span class="highlight">{value}</span>
    {:else}
        <p>{value}</p>
    {/if}
</div>

<style>
    .module {
        text-align: center;
        width: 100%;
    }
    .module h4 {
        margin-top: 0;
        color: #333;
    }
    .highlight {
        font-size: 1.5em;
        font-weight: bold;
        color: #e44d26; /* Couleur Svelte pour l'exemple */
    }
    .button button {
        background-color: #28a745;
    }
    /* Styles spécifiques par type pour un rendu plus dynamique */
    .header {
        background-color: #f0f8ff;
    }
</style>
