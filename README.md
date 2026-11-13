# CreditOptimizer
CreditOptimizerIUPB

# Structure Frontend with Vue
```
src/
├── components/       # Componentes de UI reutilizables (Botones, Modales, Tablas)
│   └── ApiStatus.vue # Componente para verificar el estado del backend (GET /)
├── composables/      # Lógica de estado y negocio aislada (Composition API)
│   ├── useUsers.ts
│   ├── useChats.ts
│   └── useSuggestions.ts
├── services/         # Configuración de Axios y llamadas HTTP puras
│   ├── apiClient.ts
│   ├── userService.ts
│   ├── chatService.ts
│   └── suggestionService.ts
├── types/            # Interfaces de TypeScript (Espejo de los DTOs de Java)
│   └── index.ts
├── views/            # Vistas principales (Páginas)
│   └── UsersView.vue
├── App.vue           # Componente raíz
└── main.ts           # Punto de entrada de la aplicación
```
