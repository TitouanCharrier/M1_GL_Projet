<script>
    let email = '';
    let password = '';
    let message = ''; 

    function handleSubmit(event) {
        event.preventDefault(); 
        
        if (email.trim() === '' || password.trim() === '') {
            message = 'Veuillez remplir tous les champs.';
            return;
        }

        if (email === 'test@example.com' && password === 'motdepasse') {
            message = 'Connexion réussie ! Bienvenue.';
            email = '';
            password = '';
        } else {
            message = 'Email ou mot de passe incorrect.';
        }
    }
</script>

<form on:submit={handleSubmit}>
    <h2>Connexion</h2>

    <div>
        <label for="email">Email</label>
        <input 
            id="email" 
            type="email" 
            bind:value={email} 
            required
        />
    </div>

    <div>
        <label for="password">Mot de passe</label>
        <input 
            id="password" 
            type="password" 
            bind:value={password} 
            required
        />
    </div>

    {#if message}
        <p class={message.includes('réussie') ? 'success' : 'error'}>{message}</p>
    {/if}

    <button type="submit">Se connecter</button>
</form>

<style>
    form {
        max-width: 400px;
        margin: 50px auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        font-family: sans-serif;
    }
    h2 {
        text-align: center;
        color: #fff;
    }
    div {
        margin-bottom: 15px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box; 
    }
    button {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    button:hover {
        background-color: #45a049;
    }
    .error {
        color: #d9534f;
        background-color: #f2dede;
        padding: 10px;
        border: 1px solid #ebccd1;
        border-radius: 4px;
        margin-top: 10px;
    }
    .success {
        color: #5cb85c;
        background-color: #dff0d8;
        padding: 10px;
        border: 1px solid #d6e9c6;
        border-radius: 4px;
        margin-top: 10px;
    }
</style>
