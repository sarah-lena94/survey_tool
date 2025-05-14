<template>
  <div class="flex flex-col items-center min-h-screen w-full">
    <header class="w-full">
      <slot name="header" />
    </header>
    <main class="flex-1 py-6 w-full">
      <slot />
    </main>
    <footer class="w-full">
      <slot name="footer" />
    </footer>
  </div>
</template>

<style scoped>
.min-h-screen {
  min-height: 100vh;
}

.flex-1 {
  flex: 1 1 0%;
}
</style>
