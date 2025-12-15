<script>
    export let items = [];
    export let filteredResources; 
    export let searchKeys = ['subjectTitle', 'title']; 
    let searchTerm = '';

    function filterItems() {
        const term = searchTerm.toLowerCase().trim();

        if (term) { 
            const filtered = items.filter(item => 
                searchKeys.some(k => 
                    item[k] && 
                    String(item[k]).toLowerCase().includes(term)
                )
            );
            filteredResources = filtered;
        } else {
            filteredResources = items; 
        }
    }

    $: searchTerm, filterItems();

    $: items, filterItems();

    $: if (items && filteredResources === undefined) {
        filteredResources = items;
    }


</script>

<div class="search-container">
    <input 
        type="text" 
        placeholder="Rechercher une ressource..." 
        bind:value={searchTerm}
        class="search-input"
    />
</div>

<style>
    .search-container {
        max-width: 600px;
        margin: 0 auto;
    }

    .search-input {
        width: 100%;
        padding: 12px;
        border: 2px solid #42b983;
        border-radius: 8px;
        font-size: 16px;
        margin-bottom: 15px;
    }

</style>

