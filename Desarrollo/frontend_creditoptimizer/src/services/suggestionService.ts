// src/services/productService.ts
import { apiClient } from './apiClient';
import type { EntitySuggestion } from '../types';

export default {
  getAll() {
    return apiClient.get<EntitySuggestion[]>('/api/products');
  },
  getById(id: number) {
    return apiClient.get<EntitySuggestion>(`/api/products/${id}`);
  },
  create(product: Omit<EntitySuggestion, 'id'>) {
    return apiClient.post<EntitySuggestion>('/api/products', product);
  },
  update(id: number, product: EntitySuggestion) {
    return apiClient.put<EntitySuggestion>(`/api/products/${id}`, product);
  },
  delete(id: number) {
    return apiClient.delete<void>(`/api/products/${id}`);
  }
};