<script>
    export let gridData = [];
    
    let numColumns = 5;

</script>

<div class="grid" style="--columns: {numColumns};">
    {#each gridData as cell}
        <div class="grid-cell">
            <CellModule 
                content={cell.content} 
                type={cell.type}
                value={cell.value}
            />
        </div>
    {/each}
</div>

<style>

    .grid {
        display: grid;
        grid-template-columns: repeat(var(--columns), 1fr);
        gap: 15px;
        padding: 10px;
        background-color: rgba(0,0,0,0);
        border-radius: 8px;
    }

    .grid-cell {
        border: 1px solid #ddd;
        padding: 15px;
        background-color: white;
        box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.05);
        border-radius: 4px;
        min-height: 100px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    
    button {
        padding: 8px 15px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }
</style>
