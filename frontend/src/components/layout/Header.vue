<script setup lang="ts">
import { RouterLink } from 'vue-router'
import Button from '../ui/Button.vue'
</script>

<template>
  <header class="border-b bg-white w-full flex justify-center">
    <div class="flex justify-center w-full">
      <div class="container flex h-16 items-center justify-between px-4 sm:px-6 lg:px-8">
        <div class="flex items-center gap-2">
          <div class="bg-gradient-to-br from-teal-500 to-purple-500 p-1.5 rounded-lg">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="20"
              height="20"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
              class="h-5 w-5 text-white"
            >
              <path d="M2 12a5 5 0 0 0 5 5 8 8 0 0 1 5 2 8 8 0 0 1 5-2 5 5 0 0 0 5-5V7H2Z" />
              <path d="M6 11v.01" />
              <path d="M10 11v.01" />
              <path d="M14 11v.01" />
              <path d="M18 11v.01" />
            </svg>
          </div>
          <RouterLink to="/" class="font-bold text-lg">Teammeter</RouterLink>
        </div>

        <div class="hidden md:flex items-center space-x-8">
          <RouterLink to="/" class="text-sm font-medium hover:text-teal-600 transition-colors">Home</RouterLink>
          <RouterLink to="/create" class="text-sm font-medium hover:text-teal-600 transition-colors">Create Survey</RouterLink>
          <RouterLink to="/about" class="text-sm font-medium hover:text-teal-600 transition-colors">About</RouterLink>
        </div>

        <div class="flex items-center gap-4">
          <RouterLink to="/signin" class="text-sm font-medium border border-gray-200 rounded-md px-4 py-1.5 hover:border-teal-500 hover:text-teal-600 transition-colors">Sign In</RouterLink>
          <RouterLink to="/get-started">
            <Button size="sm" class="bg-teal-500 hover:bg-teal-600 text-white rounded-md px-4 py-1.5">Get Started</Button>
          </RouterLink>
        </div>
      </div>
    </div>
  </header>
</template>
