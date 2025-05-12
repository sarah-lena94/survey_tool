<script setup lang="ts">
defineProps<{
  value: number
}>()
</script>

<template>
  <progress
    class="h-2 w-full appearance-none overflow-hidden rounded-full bg-gray-200"
    :value="value"
    max="100"
  >
    <div class="bg-teal-500 h-full rounded-full transition-all" :style="{ width: `${value}%` }"></div>
  </progress>
</template>
