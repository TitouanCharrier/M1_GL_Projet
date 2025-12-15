<script lang="ts">
    import { push } from 'svelte-spa-router';

    // --- Variables d'état du formulaire local ---
    // Les valeurs initiales correspondent aux exportations définies
    let title = '';
    let description = '';
    let category: 'Général' | 'Services' | 'Produits' | 'Immobilier' = 'Général';
    let price: number | null = null;
    let pricePerHour: number | null = null;
    let type: 'Resource' | 'Service' = 'Resource'; // Type d'annonce : Resource (produit/bien) ou Service

    // Catégories disponibles pour la liste déroulante
    const categoriesOptions = ['Général', 'Services', 'Produits', 'Immobilier'];

    // --- Fonction de soumission ---
    function handleSubmit() {
        // Valider les données avant l'envoi
        if (!title || !description || (type === 'Resource' && price === null) || (type === 'Service' && pricePerHour === null)) {
            alert("Veuillez remplir tous les champs obligatoires !");
            return;
        }

        // Simuler l'objet de la nouvelle annonce
        const newAd = {
            title,
            description,
            category,
            // ID et Date seront normalement générés par le serveur
            id: Date.now().toString(), 
            creationDate: new Date().toISOString(),
            type,
            // Prix conditionnel
            price: type === 'Resource' ? price : null,
            pricePerHour: type === 'Service' ? pricePerHour : null
        };

        console.log("Nouvelle annonce prête à être envoyée :", newAd);
        
        // Redirection vers la page des annonces après succès
        push('/annonces'); 
        alert(`Annonce '${title}' créée avec succès !`);
    }
</script>

<div class="ad-form-container">
    <h2>Créer une Nouvelle Annonce</h2>
    <p>Remplissez les informations ci-dessous pour publier votre ressource ou service.</p>

    <form on:submit|preventDefault={handleSubmit} class="ad-form">
        
        <section class="form-section type-category-section">
            <div class="form-group type-switch">
                <label>Type d'Annonce</label>
                <div class="radio-group">
                    <label class:active={type === 'Resource'}>
                        <input type="radio" bind:group={type} value="Resource">
                        Ressource / Produit
                    </label>
                    <label class:active={type === 'Service'}>
                        <input type="radio" bind:group={type} value="Service">
                        Service
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label for="category">Catégorie</label>
                <select id="category" bind:value={category}>
                    {#each categoriesOptions as option}
                        <option value={option}>{option}</option>
                    {/each}
                </select>
            </div>
        </section>

        <section class="form-section">
            <div class="form-group">
                <label for="title">Titre de l'Annonce *</label>
                <input id="title" type="text" bind:value={title} required placeholder="Ex: Échange d'ordinateur portable contre un vélo">
            </div>

            <div class="form-group">
                <label for="description">Description *</label>
                <textarea id="description" bind:value={description} required rows="5" placeholder="Décrivez votre bien ou service en détail..."></textarea>
            </div>
        </section>

        <section class="form-section price-section">
            <h3>Conditions d'Échange</h3>
            
            {#if type === 'Resource'}
                <div class="form-group">
                    <label for="price">Valeur d'Échange (Prix en €)*</label>
                    <input id="price" type="number" bind:value={price} min="0" required placeholder="Valeur estimée en euros">
                    <small>Indiquez la valeur du bien pour faciliter l'échange.</small>
                </div>
            {/if}

            {#if type === 'Service'}
                <div class="form-group">
                    <label for="pricePerHour">Tarif par Heure (en €)*</label>
                    <input id="pricePerHour" type="number" bind:value={pricePerHour} min="0" required placeholder="Ex: 25 €/heure">
                    <small>Tarif horaire pour la prestation du service.</small>
                </div>
            {/if}
        </section>

        <div class="form-actions">
            <button type="submit" class="btn-submit">
                Publier l'Annonce
            </button>
        </div>
    </form>
</div>

<style>
 

    .ad-form-container {
        max-width: 50em;
        min-width: 50em;
        margin: 0px auto;
        padding: 40px;
        background-color: var(--card-background);
        border-radius: 8px;
        box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
        font-family: sans-serif;
    }

    h2 {
        color: #eee;
        border-bottom: 2px solid var(--primary-color);
        padding-bottom: 15px;
        margin-bottom: 10px;
    }

    p {
        color: #6c757d;
        margin-bottom: 30px;
    }

    .form-section {
        background-color: var(--background-color);
        padding: 25px;
        border-radius: 8px;
        margin-bottom: 25px;
        border: 0px solid var(--border-color);
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }
    
    .form-section h3 {
        margin-top: 0;
        color: var(--secondary-color);
        font-size: 1.2em;
        margin-bottom: 15px;
    }

    /* --- Form Groups --- */
    .form-group {
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 8px;
        font-weight: 600;
        color: var(--secondary-color);
    }
    
    small {
        display: block;
        margin-top: 5px;
        color: #eee;
        font-size: 0.85em;
    }

    input[type="text"], 
    input[type="number"], 
    select, 
    textarea {
        width: 100%;
        padding: 12px;
        border: 1px solid var(--border-color);
        border-radius: 8px;
        box-sizing: border-box;
        transition: border-color 0.3s, box-shadow 0.3s;
        font-size: 1em;
    }

    input:focus, select:focus, textarea:focus {
        border-color: var(--primary-color);
        box-shadow: 0 0 0 3px rgba(66, 185, 131, 0.2);
        outline: none;
    }

    textarea {
        resize: vertical;
    }

    /* --- Type Switch (Radio buttons) --- */
    .type-category-section {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 20px;
        align-items: start;
    }
    
    .radio-group {
        display: flex;
        gap: 15px;
        margin-top: 10px;
    }
    
    .radio-group label {
        display: flex;
        align-items: center;
        padding: 10px 15px;
        border: 2px solid var(--border-color);
        border-radius: 8px;
        cursor: pointer;
        transition: all 0.2s;
        font-weight: normal;
        color: #eee;
    }
    
    .radio-group label.active {
        border-color: var(--primary-color);
        background-color: rgba(66, 185, 131, 0.1);
        font-weight: bold;
        color: var(--primary-color);
    }
    
    .radio-group input[type="radio"] {
        /* Masquer le bouton radio par défaut */
        display: none; 
    }

    /* --- Actions --- */
    .form-actions {
        margin-top: 30px;
        text-align: center;
    }

    .btn-submit {
        padding: 15px 40px;
        background-color: var(--primary-color);
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 1.1em;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.1s;
        box-shadow: 0 4px 10px rgba(66, 185, 131, 0.3);
    }

    .btn-submit:hover {
        background-color: var(--focus-color);
        transform: translateY(-2px);
    }
</style>
