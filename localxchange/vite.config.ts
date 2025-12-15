import { defineConfig } from 'vite'
import { svelte } from '@sveltejs/vite-plugin-svelte'

const repoName = 'M1_GL_Projet'; 

export default defineConfig({
  plugins: [svelte()],
  
  base: `/${repoName}/`, 
  
});
