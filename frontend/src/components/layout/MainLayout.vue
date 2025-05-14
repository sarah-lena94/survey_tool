<template>
  <!-- <div class="flex flex-col min-h-screen w-full"> -->
    <header>
      <slot name="header" />
    </header>
    <main class="">
      <!-- <div class=""> -->
        <slot />
      <!-- </div> -->
    </main>
    <footer>
      <slot name="footer" />
    </footer>
  <!-- </div> -->
</template>
