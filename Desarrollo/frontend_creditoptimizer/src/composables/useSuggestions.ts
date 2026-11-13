// src/composables/useSuggestions.ts
import { ref } from 'vue';
import suggestionService from '../services/suggestionService';
import type { EntitySuggestion, EntityError } from '../types';
import type { AxiosError } from 'axios';

export function useSuggestions() {
  const suggestions = ref<EntitySuggestion[]>([]);
  const currentSuggestion = ref<EntitySuggestion | null>(null);
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

  const fetchSuggestions = async () => {
    loading.value = true;
    error.value = null;
    try {
      const response = await suggestionService.getAll();
      suggestions.value = response.data;
    } catch (err) {
      handleError(err);
    } finally {
      loading.value = false;
    }
  };

  const deleteSuggestion = async (id: number) => {
    loading.value = true;
    error.value = null;
    try {
      await suggestionService.delete(id);
      suggestions.value = suggestions.value.filter(u => u.id !== id);
    } catch (err) {
      handleError(err);
    } finally {
      loading.value = false;
    }
  };

  return {
    suggestions,
    currentSuggestion,
    loading,
    error,
    fetchSuggestions,
    deleteSuggestion
  };
}