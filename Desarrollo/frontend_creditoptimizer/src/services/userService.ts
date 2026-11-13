// src/services/userService.ts
import { apiClient } from './apiClient';
import type { EntityUser } from '../types';

export default {
  getAll() {
    return apiClient.get<EntityUser[]>('/api/users');
  },
  getById(id: number) {
    return apiClient.get<EntityUser>(`/api/users/${id}`);
  },
  create(user: Omit<EntityUser, 'id'>) {
    return apiClient.post<EntityUser>('/api/users', user);
  },
  update(id: number, user: EntityUser) {
    return apiClient.put<EntityUser>(`/api/users/${id}`, user);
  },
  delete(id: number) {
    return apiClient.delete<void>(`/api/users/${id}`);
  }
};