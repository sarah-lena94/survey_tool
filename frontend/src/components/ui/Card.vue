<template>
  <div class="rounded-lg border bg-card text-card-foreground shadow-sm" data-v0-t="card">
    <slot />
  </div>
</template>

<style scoped>
.bg-card {
  background-color: white;
}

.text-card-foreground {
  color: black;
}
</style>
