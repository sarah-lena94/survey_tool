<template>
  <div class="inline-flex items-center justify-center rounded-md p-1 text-muted-foreground data-[orientation=horizontal]:space-x-1 data-[orientation=vertical]:space-y-1 bg-muted">
    <slot />
  </div>
</template>

<style scoped>
.bg-muted {
    background-color: #f3f4f6;
}

.text-muted-foreground {
    color: #6b7280;
}
</style>
