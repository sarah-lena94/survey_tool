<template>
  <div class="rounded-2xl shadow-md" data-v0-t="card">
    <slot />
  </div>
</template>

<style scoped>
.rounded-2xl {
  border-radius: 1rem;
}

.shadow-md {
  box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
}
</style>
