// src/types/index.ts

export interface EntityUser {
  id: number;
  name: string;
  email: string;
  user_type: string;
  password?: string; // Opcional en el front para no mostrarla en listas
}

export interface EntityChat {
  id: number;
  title: string;
  type_chat: string;
  user: EntityUser; // Relación anidada
}

export interface EntitySuggestion {
  id: number;
  expiration_date: string; // LocalDate en Java llega como 'YYYY-MM-DD'
  agent_answer: string;
  chat: EntityChat; // Relación anidada
}

// Interfaz para el manejo de errores estandarizado desde Spring Boot
export interface EntityError {
  title: string;
  status: number;
  detail: string;
  path: string;
  timestamp: string;
}