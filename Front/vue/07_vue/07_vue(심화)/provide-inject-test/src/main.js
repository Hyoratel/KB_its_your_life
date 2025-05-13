import './assets/main.css';

import { createApp } from 'vue';
import App from './App.vue';

const app = createApp(App);
app.config.unwrapInjectedRef = true;
window.vm = app.mount('#app');

// createApp(App).mount('#app');
