<script setup lang="ts">
defineProps<{
  value: string;
}>();

const emit = defineEmits(['update:value']);

</script>

<template>
  <input
    class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50"
    v-bind="$attrs"
    :value="value"
    @input="$emit('update:value', ($event.target as HTMLInputElement).value)"
  />
</template>

<style scoped>
.border-input {
    border-color: #d1d5db;
}

.bg-background {
    background-color: white;
}
</style>
