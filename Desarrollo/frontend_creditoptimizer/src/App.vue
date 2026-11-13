<script setup lang="ts"></script>

<template>
  <div id="app">
    <nav>
      <RouterLink to="/">Home</RouterLink> |
    </nav>

    <!-- This displays the view component that matches the current route -->
    <main>
      <RouterView />
    </main>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>