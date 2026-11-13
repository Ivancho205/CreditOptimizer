<!-- src/views/UsersView.vue -->
<script setup lang="ts">
import { onMounted } from 'vue';
import { useUsers } from '../composables/useUsers';
import ApiStatus from '../components/ApiStatus.vue';

// Extraemos la lógica y el estado del composable
const { users, loading, error, fetchUsers, deleteUser } = useUsers();

// Cargar usuarios al montar el componente
onMounted(() => {
  fetchUsers();
});
</script>

<template>
  <div class="max-w-6xl mx-auto p-6">
    <div class="flex justify-between items-center mb-8">
      <h1 class="text-3xl font-bold text-gray-800">Gestión de Usuarios</h1>
      <ApiStatus />
    </div>

    <!-- Manejo de Errores Tipados -->
    <div v-if="error" class="bg-red-100 border-l-4 border-red-500 text-red-700 p-4 mb-6 rounded">
      <p class="font-bold">{{ error.title }} (Error {{ error.status }})</p>
      <p>{{ error.detail }}</p>
    </div>

    <!-- Indicador de Carga -->
    <div v-if="loading" class="flex justify-center p-8">
      <div class="animate-spin rounded-full h-12 w-12 border-b-2 border-blue-500"></div>
    </div>

    <!-- Tabla de Usuarios -->
    <div v-else class="bg-white shadow-md rounded-lg overflow-hidden">
      <table class="min-w-full leading-normal">
        <thead>
          <tr class="bg-gray-100 text-left text-gray-600 uppercase text-sm leading-normal">
            <th class="py-3 px-6">ID</th>
            <th class="py-3 px-6">Nombre</th>
            <th class="py-3 px-6">Email</th>
            <th class="py-3 px-6">Tipo</th>
            <th class="py-3 px-6 text-center">Acciones</th>
          </tr>
        </thead>
        <tbody class="text-gray-600 text-sm">
          <tr v-for="user in users" :key="user.id" class="border-b border-gray-200 hover:bg-gray-50">
            <td class="py-3 px-6">{{ user.id }}</td>
            <td class="py-3 px-6 font-medium">{{ user.name }}</td>
            <td class="py-3 px-6">{{ user.email }}</td>
            <td class="py-3 px-6">
              <span class="bg-blue-100 text-blue-800 py-1 px-3 rounded-full text-xs">
                {{ user.user_type }}
              </span>
            </td>
            <td class="py-3 px-6 text-center">
              <button 
                @click="deleteUser(user.id)"
                class="bg-red-500 hover:bg-red-600 text-white py-1 px-3 rounded text-xs transition duration-200"
              >
                Eliminar
              </button>
            </td>
          </tr>
          <tr v-if="users.length === 0">
            <td colspan="5" class="py-8 text-center text-gray-500">No hay usuarios registrados.</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>