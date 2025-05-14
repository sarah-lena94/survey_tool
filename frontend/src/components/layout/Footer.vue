<template>
  <footer class="border-t bg-white flex justify-center">
    <div class="flex justify-center w-full">
      <div class="container flex flex-col gap-4 py-8 md:flex-row md:items-center md:justify-between md:py-6 px-4 sm:px-6 lg:px-8">
        <div class="flex items-center gap-2">
          <div class="bg-gradient-to-br from-teal-500 to-purple-500 p-1.5 rounded-lg">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="20"
              height="20"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
              class="h-5 w-5 text-white"
            >
              <path d="M2 12a5 5 0 0 0 5 5 8 8 0 0 1 5 2 8 8 0 0 1 5-2 5 5 0 0 0 5-5V7H2Z" />
              <path d="M6 11v.01" />
              <path d="M10 11v.01" />
              <path d="M14 11v.01" />
              <path d="M18 11v.01" />
            </svg>
          </div>
          <span class="font-bold text-lg">
            Teammeter
          </span>
        </div>
        <div class="text-center md:text-left text-sm text-gray-500">
          © {{ new Date().getFullYear() }} Teammeter. All rights reserved.
        </div>
        <div class="flex justify-center md:justify-end gap-8">
          <a href="#" class="text-sm text-gray-500 hover:text-teal-600 transition-colors">
            Terms
          </a>
          <a href="#" class="text-sm text-gray-500 hover:text-teal-600 transition-colors">
            Privacy
          </a>
          <a href="#" class="text-sm text-gray-500 hover:text-teal-600 transition-colors">
            Contact
          </a>
        </div>
      </div>
    </div>
  </footer>
</template>
