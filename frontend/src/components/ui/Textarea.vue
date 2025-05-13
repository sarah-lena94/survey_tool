<script setup lang="ts">
const props = defineProps({
  modelValue: String,
});
const emit = defineEmits(['update:modelValue']);

function handleInput(event: Event) {
  const target = event.target as HTMLTextAreaElement;
  emit('update:modelValue', target.value);
}
</script>

<template>
  <textarea
    :value="props.modelValue"
    @input="handleInput"
    class="flex min-h-[100px] w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50"
    v-bind="$attrs"
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
