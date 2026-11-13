// src/composables/useUsers.ts
import { ref } from 'vue';
import userService from '../services/userService';
import type { EntityUser, EntityError } from '../types';
import type { AxiosError } from 'axios';

export function useUsers() {
  const users = ref<EntityUser[]>([]);
  const currentUser = ref<EntityUser | null>(null);
  const loading = ref<boolean>(false);
  const error = ref<EntityError | null>(null);

  // Función interna para parsear errores de Axios a nuestra EntityError
  const handleError = (err: unknown) => {
    const axiosError = err as AxiosError<EntityError>;
    error.value = axiosError.response?.data || {
      title: 'Error de conexión',
      status: 500,
      detail: 'No se pudo conectar con el servidor',
      path: '',
      timestamp: new Date().toISOString()
    };
  };

  const fetchUsers = async () => {
    loading.value = true;
    error.value = null;
    try {
      const response = await userService.getAll();
      users.value = response.data;
    } catch (err) {
      handleError(err);
    } finally {
      loading.value = false;
    }
  };

  const deleteUser = async (id: number) => {
    loading.value = true;
    error.value = null;
    try {
      await userService.delete(id);
      users.value = users.value.filter(u => u.id !== id);
    } catch (err) {
      handleError(err);
    } finally {
      loading.value = false;
    }
  };

  return {
    users,
    currentUser,
    loading,
    error,
    fetchUsers,
    deleteUser
  };
}