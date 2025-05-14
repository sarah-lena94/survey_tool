<script setup lang="ts">
defineProps<{
  value: number
}>()
</script>
<style>
progress {
  appearance: none;
  -webkit-appearance: none;
  width: 100%;
  height: 20px;
  border: none;
  background-color: #f0f0f0;
 border-radius: 10px;
  overflow: hidden;
}

progress::-webkit-progress-value {
  background-color: #7e22ce;
  border-radius: 10px;
  transition: width 0.3s ease;
}

progress::-webkit-progress-bar {
  background-color: #f0f0f0;
  border-radius: 10px;
}

progress::-moz-progress-bar {
  background-color: #7e22ce;
  border-radius: 10px;
  transition: width 0.3s ease;
}
</style>
<template>
  <progress
    class="h-2 w-full appearance-none overflow-hidden rounded-full bg-gray-200"
    :value="value"
    max="100"
  >
    <div class="bg-teal-500 h-full rounded-full transition-all" :style="{ width: `${value}%` }"></div>
  </progress>
</template>
