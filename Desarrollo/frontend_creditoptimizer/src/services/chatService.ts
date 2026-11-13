// src/services/chatService.ts
import { apiClient } from './apiClient';
import type { EntityChat } from '../types';

export default {
  getAll() {
    return apiClient.get<EntityChat[]>('/api/chats');
  },
  getById(id: number) {
    return apiClient.get<EntityChat>(`/api/chats/${id}`);
  },
  create(chat: Omit<EntityChat, 'id'>) {
    return apiClient.post<EntityChat>('/api/chats', chat);
  },
  update(id: number, chat: EntityChat) {
    return apiClient.put<EntityChat>(`/api/chats/${id}`, chat);
  },
  delete(id: number) {
    return apiClient.delete<void>(`/api/chats/${id}`);
  }
};