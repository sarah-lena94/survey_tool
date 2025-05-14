<script setup lang="ts">
defineProps<{
  value: string;
}>();

const emit = defineEmits(['update:value']);

</script>

<template>
  <input
    class="flex h-11 w-full rounded-lg border border-input bg-background px-4 py-2 text-sm ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-teal-300 focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50"
    v-bind="$attrs"
    :value="value"
    @input="$emit('update:value', ($event.target as HTMLInputElement).value)"
  />
</template>

<style scoped>
.border-input {
    border-color: #e2e8f0;
}

.bg-background {
    background-color: white;
}

.rounded-lg {
    border-radius: 0.5rem;
}

.placeholder\:text-muted-foreground::placeholder {
    color: #94a3b8;
}

.h-11 {
    height: 2.75rem;
}
</style>
