<template>
  <div class="flex flex-col min-h-screen">
    <header>
      <slot name="header" />
    </header>
    <main class="flex-1">
      <slot />
    </main>
    <footer>
      <slot name="footer" />
    </footer>
  </div>
</template>
