<template>
  <label class="flex items-center space-x-2 cursor-pointer">
    <input
      type="radio"
      class="h-5 w-5 rounded-full border-gray-300 text-teal-500 focus:ring-teal-500"
      v-bind="$attrs"
    />
    <span>
      <slot />
    </span>
  </label>
</template>
