<script setup lang="ts">
defineProps<{
  variant?: 'default' | 'outline' | 'ghost'
  size?: 'sm' | 'md' | 'lg'
  disabled?: boolean
}>()
</script>

<template>
  <button
    class="inline-flex items-center justify-center rounded-full font-medium transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-offset-2 disabled:opacity-50 disabled:pointer-events-none"
    :class="[
      variant === 'outline'
        ? 'border border-teal-300 text-teal-700 hover:bg-teal-50'
        : variant === 'ghost'
          ? 'text-teal-700 hover:bg-teal-50'
          : 'bg-teal-500 hover:bg-teal-600 text-white',
      size === 'sm'
        ? 'h-8 px-3 text-sm'
        : size === 'lg'
          ? 'h-12 px-6 text-lg'
          : 'h-10 px-4 text-base'
    ]"
    :disabled="disabled"
  >
    <slot />
  </button>
</template>
