<script>
  import { onMount } from 'svelte';
    
  onMount(() => {
      window.scrollTo(0, 0); 
  });
 
  let user = {
        name: 'Jean Dupont',
        email: 'jean.dupont@example.com',
        phone: '06 12 34 56 78',
        isEditing: false
    };

    let orders = [
        { id: '#12345', date: '2025-12-10', total: 79.99, status: 'Livrée' },
        { id: '#12346', date: '2025-11-25', total: 120.50, status: 'En cours' },
        { id: '#12347', date: '2025-11-01', total: 45.00, status: 'Annulée' }
    ];

    let addresses = [
        { id: 1, label: 'Domicile', street: '15 Rue de la Paix', city: 'Paris', zip: '75002', country: 'France' },
        { id: 2, label: 'Bureau', street: '22 Avenue des Champs', city: 'Lyon', zip: '69007', country: 'France' }
    ];

    let activeTab = 'profile'; // 'profile', 'orders', 'addresses'

    function toggleEdit() {
        user.isEditing = !user.isEditing;
    }

    function saveProfile() {
        // Logique pour envoyer les données mises à jour à l'API
        console.log('Profil mis à jour :', user);
        user.isEditing = false;
        // Ici, vous ajouteriez un message de succès
    }

    function getStatusClass(status) {
        switch (status) {
            case 'Livrée': return 'status-delivered';
            case 'En cours': return 'status-in-progress';
            case 'Annulée': return 'status-cancelled';
            default: return '';
        }
    }
</script>

<div class="dashboard-container">
    <aside class="sidebar">
        <h2>Mon Compte</h2>
        <nav>
            <button
                class:active={activeTab === 'profile'}
                on:click={() => activeTab = 'profile'}
            >
                Informations Personnelles
            </button>
            <button
                class:active={activeTab === 'addresses'}
                on:click={() => activeTab = 'addresses'}
            >
                Mes Adresses
            </button>
        </nav>
    </aside>

    <main class="content">
        {#if activeTab === 'profile'}
            <section class="card profile-section">
                <h3>Informations Personnelles</h3>
                
                {#if user.isEditing}
                    <div class="form-group">
                        <label for="name">Nom complet</label>
                        <input id="name" type="text" bind:value={user.name}>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input id="email" type="email" bind:value={user.email} disabled>
                    </div>
                    <div class="form-group">
                        <label for="phone">Téléphone</label>
                        <input id="phone" type="tel" bind:value={user.phone}>
                    </div>
                    <div class="actions">
                        <button class="btn btn-primary" on:click={saveProfile}>Enregistrer</button>
                        <button class="btn btn-secondary" on:click={toggleEdit}>Annuler</button>
                    </div>
                {:else}
                    <p><strong>Nom :</strong> {user.name}</p>
                    <p><strong>Email :</strong> {user.email}</p>
                    <p><strong>Téléphone :</strong> {user.phone}</p>
                    <div class="actions">
                        <button class="btn btn-secondary" on:click={toggleEdit}>Modifier</button>
                    </div>
                {/if}
            </section>
        
        {:else if activeTab === 'addresses'}
            <section class="card addresses-section">
                <h3>Mes Adresses de Livraison</h3>
                <div class="address-grid">
                    {#each addresses as address (address.id)}
                        <div class="address-card">
                            <h4>{address.label}</h4>
                            <p>{address.street}</p>
                            <p>{address.zip} {address.city}</p>
                            <p>{address.country}</p>
                            <div class="address-actions">
                                <button class="btn-icon">✏️</button>
                                <button class="btn-icon">🗑️</button>
                            </div>
                        </div>
                    {/each}
                    <div class="add-address-card">
                        <button class="btn-add">+ Ajouter une adresse</button>
                    </div>
                </div>
            </section>
        {/if}
    </main>
</div>

<style>

    .dashboard-container {
        display: flex;
        max-width: 1200px;
        margin: 40px auto;
        border-radius: 8px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.05);
        background-color: var(--card-background);
        min-height: 70vh;
        border: 1px solid var(--main-color, #42b983);
    }

    .sidebar {
        width: 280px;
        padding: 30px;
        border-right: 1px solid var(--border-color);
        background-color: var(--card-background);
        border-top-left-radius: 12px;
        border-bottom-left-radius: 12px;
    }

    .sidebar h2 {
        color: var(--primary-color);
        margin-top: 0;
        margin-bottom: 30px;
        font-size: 1.8em;
    }

    .sidebar nav button {
        display: block;
        width: 100%;
        padding: 12px 15px;
        margin-bottom: 10px;
        text-align: left;
        background: none;
        border: none;
        cursor: pointer;
        font-size: 1em;
        color: var(--text-color);
        border-radius: 8px;
        transition: background-color 0.2s, color 0.2s;
    }

    .sidebar nav button:hover {
        background-color: var(--background-color);
    }

    .sidebar nav button.active {
        background-color: var(--primary-color);
        color: white;
        font-weight: bold;
    }

    .content {
        flex-grow: 1;
        padding: 40px;
        background-color: var(--background-color);
        border-top-right-radius: 12px;
        border-bottom-right-radius: 12px;
    }

    h3 {
        color: var(--primary-color);
        border-bottom: 2px solid var(--border-color);
        padding-bottom: 10px;
        margin-bottom: 25px;
        font-size: 1.5em;
    }

    .card {
        background-color: var(--card-background);
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.04);
        margin-bottom: 30px;
    }

    /* --- Formulaires et Boutons --- */
    .form-group {
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: 600;
        color: var(--secondary-color);
    }

    input[type="text"], input[type="email"], input[type="tel"] {
        width: 100%;
        padding: 10px;
        border: 1px solid var(--border-color);
        border-radius: 8px;
        box-sizing: border-box;
        transition: border-color 0.3s;
    }

    input:focus {
        border-color: var(--primary-color);
        outline: none;
    }

    .actions {
        margin-top: 30px;
        display: flex;
        gap: 15px;
    }

    .btn-primary, .btn-secondary {
        padding: 10px 20px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        font-weight: bold;
        transition: opacity 0.2s, background-color 0.2s;
    }

    .btn-primary {
        background-color: var(--primary-color);
        color: white;
    }

    .btn-secondary {
        background-color: var(--background-color);
        color: white;
    }

    .btn-primary:hover, .btn-secondary:hover {
        opacity: 0.9;
    }

    /* --- Adresses Grid --- */
    .address-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
        gap: 20px;
    }

    .address-card, .add-address-card {
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
        background-color: var(--card-background);
        border: 1px solid var(--border-color);
        position: relative;
    }

    .address-card h4 {
        margin-top: 0;
        color: var(--primary-color);
        font-size: 1.2em;
    }

    .address-actions {
        position: absolute;
        top: 15px;
        right: 15px;
        display: flex;
        gap: 5px;
    }

    .btn-icon {
        background: none;
        border: none;
        cursor: pointer;
        font-size: 1.2em;
        padding: 5px;
    }

    .add-address-card {
        display: flex;
        align-items: center;
        justify-content: center;
        border: 2px dashed var(--border-color);
        background-color: var(--background-color);
        min-height: 150px;
    }

    .btn-add {
        padding: 10px 15px;
        background-color: transparent;
        border: 1px solid var(--primary-color);
        color: var(--primary-color);
        border-radius: 8px;
        cursor: pointer;
        transition: background-color 0.2s, color 0.2s;
    }

    .btn-add:hover {
        background-color: var(--primary-color);
        color: white;
    }
</style>
