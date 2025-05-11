<script setup lang="ts">
import { RouterLink } from 'vue-router'
import Button from '@/components/ui/Button.vue'
</script>

<template>
  <header class="border-b bg-white">
    <div class="container flex h-16 items-center justify-between px-4 md:px-6">
      <div class="flex items-center gap-2">
        <div class="bg-gradient-to-br from-teal-500 to-purple-500 p-2 rounded-xl">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            class="h-6 w-6 text-white"
          >
            <path d="M2 12a5 5 0 0 0 5 5 8 8 0 0 1 5 2 8 8 0 0 1 5-2 5 5 0 0 0 5-5V7H2Z" />
            <path d="M6 11v.01" />
            <path d="M10 11v.01" />
            <path d="M14 11v.01" />
            <path d="M18 11v.01" />
          </svg>
        </div>
        <span class="font-bold text-xl bg-gradient-to-r from-teal-600 to-purple-600 bg-clip-text text-transparent">
          Teammeter
        </span>
      </div>
      <nav class="hidden md:flex gap-6">
        <RouterLink to="/" class="text-sm font-medium hover:text-teal-600 transition-colors">
          Home
        </RouterLink>
        <RouterLink to="/create" class="text-sm font-medium hover:text-teal-600 transition-colors">
          Create Survey
        </RouterLink>
        <RouterLink to="#" class="text-sm font-medium hover:text-teal-600 transition-colors">
          About
        </RouterLink>
      </nav>
      <div class="flex items-center gap-2">
        <RouterLink to="/create">
          <Button
            variant="outline"
            size="sm"
            class="hidden md:flex border-teal-300 text-teal-700 hover:bg-teal-50"
          >
            Sign In
          </Button>
        </RouterLink>
        <RouterLink to="/create">
          <Button
            size="sm"
            class="bg-gradient-to-r from-teal-500 to-teal-600 hover:from-teal-600 hover:to-teal-700 rounded-full shadow-md hover:shadow-lg transition-all duration-300"
          >
            Get Started
          </Button>
        </RouterLink>
      </div>
    </div>
  </header>
</template>
