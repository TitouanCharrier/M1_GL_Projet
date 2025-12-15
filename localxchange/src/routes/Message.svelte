<script lang="ts">
    import { onMount } from 'svelte';
      
    onMount(() => {
        window.scrollTo(0, 0); 
    });
    
    // --- Interfaces TypeScript ---
    interface Message {
        id: number;
        senderId: number;
        senderName: string;
        content: string;
        timestamp: string;
        isMine?: boolean; // Pour l'affichage
    }

    interface Conversation {
        id: number;
        contactName: string;
        lastMessage: string;
        contactId: number;
    }

    // --- Variables d'état ---
    // Simuler l'utilisateur connecté
    const currentUserId = 1;
    const currentUserName = 'Moi (Jean)'; 
    
    // Conversation sélectionnée
    let activeConversationId: number | null = 2; // ID de la conversation active
    let activeContactName: string = 'Alice Dupont';

    // Messages de la conversation active
    let messages: Message[] = [];
    
    // Contenu du message en cours de saisie
    let newMessageContent: string = '';

    // Liste des conversations (simulée)
    let conversations: Conversation[] = [
        { id: 1, contactName: 'Bob Martin', lastMessage: 'J\'arrive dans 5 minutes.', contactId: 20 },
        { id: 2, contactName: 'Alice Dupont', lastMessage: 'Super pour l\'échange!', contactId: 5 },
        { id: 3, contactName: 'Équipe Support', lastMessage: 'Votre demande est en cours.', contactId: 99 },
    ];

    // --- Connexion WebSocket (Simulée) ---
    // Dans une application réelle, ce serait l'URL de votre endpoint WebSocket Spring Boot (souvent via STOMP).
    let websocket: WebSocket | null = null;
    const WEBSOCKET_URL = 'ws://localhost:8080/ws-chat'; 
    const REST_API_URL = 'http://localhost:8080/api/messages';


    onMount(() => {
        // 1. Initialiser la connexion (pour le temps réel)
        connectWebSocket();
        
        // 2. Charger les messages initiaux de la conversation active
        if (activeConversationId) {
            loadMessages(activeConversationId);
        }
    });

    function connectWebSocket() {
        // C'est ici que vous établiriez la connexion STOMP/Websocket
        // websocket = new WebSocket(WEBSOCKET_URL); 
        
        // Logique de simulation :
        console.log('Tentative de connexion WebSocket...');
        // Simuler la réception d'un message après 3 secondes
        setTimeout(() => {
            handleReceivedMessage({ 
                id: Date.now(), 
                senderId: 5, 
                senderName: activeContactName, 
                content: "Salut ! C'est bon pour l'échange demain ?", 
                timestamp: new Date().toISOString()
            });
            console.log('Connexion WebSocket simulée établie.');
        }, 3000);
    }
    
    // --- Gestion des données via API REST (simulée) ---

    function loadMessages(conversationId: number) {
        // Requête REST pour charger l'historique de la conversation
        console.log(`Chargement des messages pour la conversation ID: ${conversationId}`);
        // Dans une vraie app : fetch(`${REST_API_URL}/${conversationId}`)
        
        // Données de simulation (pour Alice - ID 5)
        messages = [
            { id: 1, senderId: 5, senderName: 'Alice', content: 'Bonjour Jean, intéressée par votre annonce!', timestamp: '2025-12-14T10:00:00Z' },
            { id: 2, senderId: 1, senderName: currentUserName, content: 'Super ! Quel échange proposez-vous ?', timestamp: '2025-12-14T10:05:00Z' },
            { id: 3, senderId: 5, senderName: 'Alice', content: 'J\'ai un vélo de course presque neuf.', timestamp: '2025-12-14T10:15:00Z' },
        ].map(msg => ({ 
            ...msg, 
            isMine: msg.senderId === currentUserId 
        }));
    }

    function selectConversation(id: number, name: string) {
        if (activeConversationId === id) return;
        activeConversationId = id;
        activeContactName = name;
        loadMessages(id);
    }

    // --- Envoi de messages (WebSockets/STOMP) ---

    function sendMessage() {
        if (newMessageContent.trim() === '' || !activeConversationId) return;

        const messageToSend: Message = {
            id: Date.now(),
            senderId: currentUserId,
            senderName: currentUserName,
            content: newMessageContent.trim(),
            timestamp: new Date().toISOString(),
            isMine: true
        };

        // 1. Envoi au serveur via WebSocket/STOMP
        // Dans une vraie app : websocket?.send(JSON.stringify(messageToSend));
        console.log('Message envoyé via WebSocket (simulé):', messageToSend);

        // 2. Mise à jour de l'UI (optimistic update)
        messages = [...messages, messageToSend];
        newMessageContent = '';
        
    }

    // --- Réception de messages (WebSockets) ---

    function handleReceivedMessage(receivedMsg: Omit<Message, 'isMine'>) {
        if (receivedMsg.senderId !== currentUserId) {
            receivedMsg.isMine = false;
            messages = [...messages, receivedMsg as Message];
        }
    }

    // --- Fonction utilitaire pour le défilement ---
    let messagesEnd: HTMLElement;
    //function scrollToBottom() {
    //    messagesEnd.scrollIntoView({ behavior: 'smooth' });
    //}
    // Rerun la fonction après chaque mise à jour de 'messages'
    //$: if (messages.length) setTimeout(scrollToBottom, 50); 
</script>

<div class="chat-container">
    
    <aside class="conversation-list">
        <h3>Conversations</h3>
        {#each conversations as conv (conv.id)}
            <button 
                class="conversation-item"
                class:active={conv.id === activeConversationId}
                on:click={() => selectConversation(conv.id, conv.contactName)}
            >
                <span class="contact-name">{conv.contactName}</span>
                <span class="last-message">{conv.lastMessage}</span>
            </button>
        {/each}
    </aside>

    <main class="chat-window">
        {#if activeConversationId}
            <header class="chat-header">
                <h2>{activeContactName}</h2>
                <span class="status-dot online"></span>
            </header>
            
            <div class="messages-area">
                {#each messages as msg (msg.id)}
                    <div class="message-bubble" class:mine={msg.isMine}>
                        <div class="message-content">
                            <p>{msg.content}</p>
                            <small>{new Date(msg.timestamp).toLocaleTimeString()}</small>
                        </div>
                    </div>
                {/each}
                <div bind:this={messagesEnd} style="height: 0px;"></div>
            </div>
            
            <footer class="input-area">
                <input 
                    type="text" 
                    bind:value={newMessageContent} 
                    on:keydown={(e) => { if (e.key === 'Enter') sendMessage(); }}
                    placeholder="Écrivez votre message..."
                >
                <button on:click={sendMessage} class="send-btn">
                    Envoyer
                </button>
            </footer>

        {:else}
            <div class="no-conversation">
                <p>Sélectionnez une conversation pour commencer à discuter.</p>
            </div>
        {/if}
    </main>
</div>

<style>
    :root {
        --chat-secondary-bg: var(--card-background); 
        --chat-text-other: var(--secondary-color); 
        --chat-bubble-mine: var(--primary-color);
        --chat-bubble-other: var(--background-color); 
        --chat-text-other-bubble: var(--secondary-color); 
        --chat-text-mine-bubble: var(--card-background); 
    }

    .chat-container {
        display: flex;
        height: 80vh; 
        max-width: 80em;
        margin: 40px auto;
        border: 1px solid var(--border-color);
        border-radius: 12px;
        overflow: hidden;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.4); /* Ombre plus foncée */
        background-color: var(--card-background);
        color: var(--secondary-color); /* Texte principal clair */
    }

    .conversation-list {
        width: 300px;
        border-right: 1px solid var(--border-color);
        background-color: var(--card-background); /* Fond sombre de la carte */
        padding: 20px 0;
        overflow-y: auto;
    }

    .conversation-list h3 {
        padding: 0 20px 10px;
        color: var(--primary-color); /* Couleur d'accentuation */
        border-bottom: 1px solid rgba(255, 255, 255, 0.1); /* Séparateur clair subtil */
        margin-top: 0;
    }

    .conversation-item {
        display: block;
        width: 100%;
        padding: 15px 20px;
        text-align: left;
        background: none;
        border: none;
        border-left: 5px solid transparent;
        cursor: pointer;
        transition: background-color 0.2s, border-left-color 0.2s;
    }

    .conversation-item:hover {
        background-color: var(--background-color); /* Légèrement plus clair au survol */
    }

    .conversation-item.active {
        background-color: var(--background-color); /* Arrière-plan de l'élément sélectionné */
        border-left-color: var(--primary-color); /* Ligne d'accentuation */
    }

    .contact-name {
        display: block;
        font-weight: bold;
        color: var(--secondary-color);
    }

    .last-message {
        display: block;
        font-size: 0.9em;
        color: rgba(255, 255, 255, 0.6); /* Texte gris clair */
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    /* --- 2. Fenêtre de Chat Active --- */
    .chat-window {
        flex-grow: 1;
        display: flex;
        flex-direction: column;
        background-color: var(--background-color); /* Arrière-plan principal foncé */
    }

    .chat-header {
        display: flex;
        align-items: center;
        padding: 15px 20px;
        background-color: var(--card-background); /* Fond de la carte */
        border-bottom: 1px solid var(--border-color);
        color: var(--secondary-color);
    }
    
    .chat-header h2 {
        margin: 0;
        font-size: 1.3em;
        color: var(--secondary-color);
        margin-right: 10px;
    }

    .status-dot {
        width: 10px;
        height: 10px;
        border-radius: 50%;
        background-color: #666;
    }

    .status-dot.online {
        background-color: var(--primary-color);
    }

    /* --- Zone des Messages --- */
    .messages-area {
        flex-grow: 1;
        padding: 20px;
        overflow-y: auto;
        display: flex;
        flex-direction: column;
    }

    .message-bubble {
        display: flex;
        margin-bottom: 10px;
        max-width: 70%;
    }

    .message-bubble.mine {
        margin-left: auto;
        justify-content: flex-end;
    }

    .message-content {
        padding: 10px 15px;
        border-radius: 18px;
        line-height: 1.4;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.3);
    }

    .message-bubble p {
        margin: 0;
        word-wrap: break-word;
    }

    .message-bubble small {
        display: block;
        text-align: right;
        font-size: 0.75em;
        color: rgba(255, 255, 255, 0.6); /* Horodatage clair */
        margin-top: 3px;
    }

    /* Styles pour les bulles */
    /* Bulles des autres (sombre) */
    .message-bubble:not(.mine) .message-content {
        background-color: var(--card-background); 
        color: var(--secondary-color); /* Texte clair */
        border-top-left-radius: 2px;
    }
    .message-bubble:not(.mine) small {
         color: rgba(255, 255, 255, 0.4);
    }

    /* Bulles de l'utilisateur (primaire) */
    .message-bubble.mine .message-content {
        background-color: var(--primary-color);
        color: var(--card-background); /* Texte foncé pour contraster avec le vert */
        border-top-right-radius: 2px;
    }
    .message-bubble.mine small {
         color: rgba(255, 255, 255, 0.7);
    }


    /* --- Champ de Saisie (Footer) --- */
    .input-area {
        display: flex;
        padding: 15px 20px;
        border-top: 1px solid var(--border-color);
        background-color: var(--card-background);
    }

    .input-area input {
        flex-grow: 1;
        padding: 10px 15px;
        /* Utiliser le background-color comme fond du champ de saisie */
        background-color: var(--background-color); 
        border: 1px solid var(--background-color); 
        color: var(--secondary-color); /* Texte clair dans le champ */
        border-radius: 25px; 
        margin-right: 10px;
        font-size: 1em;
        transition: border-color 0.2s;
    }
    
    .input-area input:focus {
        border-color: var(--primary-color);
        outline: none;
    }

    .send-btn {
        padding: 10px 20px;
        background-color: var(--primary-color);
        color: white;
        border: none;
        border-radius: 25px;
        cursor: pointer;
        font-weight: bold;
        transition: background-color 0.2s;
    }

    .send-btn:hover {
        background-color: var(--focus-color);
    }
    
    .no-conversation {
        flex-grow: 1;
        display: flex;
        align-items: center;
        justify-content: center;
        color: rgba(255, 255, 255, 0.5);
    }
</style>
