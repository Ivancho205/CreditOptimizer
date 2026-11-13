import { createRouter, createWebHistory } from 'vue-router'
import UserView from '../views/usersView.vue'



const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'user', component: UserView },
  ]
})

export default router