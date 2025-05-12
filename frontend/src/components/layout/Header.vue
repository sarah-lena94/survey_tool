<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>

<template>
  <header class="border-b bg-white">
    <div class="container flex h-16 items-center justify-between px-4 md:px-6">
      <RouterLink to="/" class="text-sm font-medium hover:text-teal-600 transition-colors">
        < Back to Home
      </RouterLink>
      <span class="font-bold text-xl">
        Team Feedback
      </span>
      <div></div>
    </div>
  </header>
</template>
