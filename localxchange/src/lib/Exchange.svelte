<script>
    import { createEventDispatcher } from 'svelte';

    export let id;
    export let date;          
    export let status;
    export let subjectTitle = "test";
    export let user1;     
    export let user2;     
    export let res1;     
    export let res2;     
    export let isUser1 = false; 

    
    const dispatch = createEventDispatcher();


    function formatStatus(stat) {
        if (!stat) return 'Inconnu';
        return stat.charAt(0).toUpperCase() + stat.slice(1).toLowerCase();
    }


    function handleAction(action) {
        dispatch(action, { exchangeId: id });
    }
</script>

<article class="exchange-card">
    <header class="card-header">
        <h3>{subjectTitle}</h3>
        <span class="id-info">ID: {id}</span>
    </header>

    <div class="card-body">
        
        <div class="status-badge status-{status.toLowerCase()}">
            Statut : {formatStatus(status)}
        </div>

        <div class="details-grid">
            <div class="detail-group participant-group">
                <span class="label">Participants :</span>
                <span class="value">{user1} avec {user2}</span>
            </div>
            
            <div class="detail-group resource-group">
                <span class="label">Ressources Échangées :</span>
                <span class="value resource-title">{res1}</span>
                <span class="value resource-title">contre</span>
                <span class="value resource-title">{res2}</span>
            </div>
            
            <div class="detail-group date-group">
                <span class="label">Date:</span>
                <span class="value date-value">
                    {new Date(date).toLocaleDateString()}
                </span>
            </div>
        </div>
    </div>

</article>

<style>
    .exchange-card {
        background-color: #2c3e50;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        margin: 15px;
        max-width: 450px;
        min-width: 300px;
        font-family: sans-serif;
        border: 1px solid var(--status-color, #42b983);
    }
    
    .card-header {
        border-radius: 8px;
        padding: 15px;
        background-color: #2c3e50;
    }

    .card-header h3 {
        margin: 0;
        font-size: 1.2em;
        color: #fff;
    }
    
    .status-badge {
        padding: 5px 10px;
        border-radius: 4px;
        font-size: 0.9em;
        margin-bottom: 15px;
        text-align: center;
        width: fit-content;
        margin-left: 15px;
    }

    .status-pending, .status-sent, .status-pending-info {
        background-color: #fff3cd; 
        color: #856404;
    }
    .status-accepted {
        background-color: #d4edda; 
        color: #155724;
        --status-color: #28a745;
    }
    .status-refused, .status-cancelled {
        background-color: #f8d7da; 
        color: #721c24;
        --status-color: #dc3545;
    }

    .card-body {
        padding: 15px;
    }

    .details-grid {
        display: flex;
        flex-direction: column;
        gap: 15px;
    }

    .detail-group {
        padding: 10px;
        border-radius: 4px;
        box-shadow: 4px 4px 6px rgba(66, 185, 131, 0.1);
        background-color: #374d64;
    }

    .label {
        font-size: 0.8em;
        color: #fff;
        font-weight: 500;
        display: block;
        margin-bottom: 3px;
    }

    .value {
        font-size: 1em;
        color: #fff;
    }
    
    .resource-title {
        display: block;
        font-size: 0.9em;
        margin-left: 10px;
        color: #fff;
    }

    .card-footer {
        padding: 15px;
        border-top: 1px solid #eee;
        display: flex;
        gap: 10px;
        justify-content: flex-end;
        background-color: #fafafa;
    }

    .action-btn {
        padding: 8px 15px;
        color: black;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 0.9em;
        transition: opacity 0.2s;
    }
    
    .action-btn:disabled {
        opacity: 0.7;
        cursor: not-allowed;
    }

</style>
