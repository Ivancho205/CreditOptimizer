// src/composables/useChats.ts
import { ref } from 'vue';
import chatService from '../services/chatService';
import type { EntityChat, EntityError } from '../types';
import type { AxiosError } from 'axios';

export function useChats() {
  const chats = ref<EntityChat[]>([]);
  const currentChat = ref<EntityChat | null>(null);
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

  const fetchChats = async () => {
    loading.value = true;
    error.value = null;
    try {
      const response = await chatService.getAll();
      chats.value = response.data;
    } catch (err) {
      handleError(err);
    } finally {
      loading.value = false;
    }
  };

  const deleteChat = async (id: number) => {
    loading.value = true;
    error.value = null;
    try {
      await chatService.delete(id);
      chats.value = chats.value.filter(u => u.id !== id);
    } catch (err) {
      handleError(err);
    } finally {
      loading.value = false;
    }
  };

  return {
    chats,
    currentChat,
    loading,
    error,
    fetchChats,
    deleteChat
  };
}