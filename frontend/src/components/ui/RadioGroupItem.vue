<template>
  <div class="flex items-center space-x-2">
    <input
      type="radio"
      class="h-4 w-4 border-input ring-offset-background focus:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50"
      v-bind="$attrs"
    />
    <slot />
  </div>
</template>

<style scoped>
.border-input {
    border-color: #d1d5db;
}
</style>
