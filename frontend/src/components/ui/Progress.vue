<script setup lang="ts">
defineProps<{
  value: number
}>()
</script>

<template>
  <progress
    class="h-2 w-full appearance-none overflow-hidden rounded-full bg-secondary"
    :value="value"
    max="100"
  ></progress>
</template>

<style scoped>
progress::-webkit-progress-bar {
  background-color: #e5e7eb;
}

progress::-webkit-progress-value {
  background-color: #0d9488;
}

progress::-moz-progress-bar {
  background-color: #0d9488;
}

.bg-secondary {
    background-color: #e5e7eb;
}
</style>
