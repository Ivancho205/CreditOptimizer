<!-- src/components/ApiStatus.vue -->
<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { apiClient } from '../services/apiClient';

const statusMessage = ref('Verificando API...');
const isOnline = ref(false);

onMounted(async () => {
  try {
    const response = await apiClient.get<{mensaje: string}>('/');
    statusMessage.value = response.data.mensaje;
    isOnline.value = true;
  } catch (error) {
    statusMessage.value = 'API Offline o Error de Conexión';
    isOnline.value = false;
  }
});
</script>

<template>
  <div :class="['px-4 py-2 rounded shadow-md font-semibold text-white', isOnline ? 'bg-green-500' : 'bg-red-500']">
    {{ statusMessage }}
  </div>
</template>