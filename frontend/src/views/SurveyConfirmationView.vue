<script setup lang="ts">
import MainLayout from '../components/layout/MainLayout.vue';
import Header from '../components/layout/Header.vue';
import Footer from '../components/layout/Footer.vue';
import { ref } from 'vue';

const showResults = ref(false);

</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8 max-w-3xl flex flex-col items-center">
      <div class="rounded-2xl shadow-lg p-8 bg-gradient-to-br from-teal-50 to-purple-50 flex flex-col items-center space-y-4">
        <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 24 24" fill="none" stroke="#A855F7" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
          <path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"></path>
          <polyline points="22 4 12 14.01 9 11.01"></polyline>
        </svg>
        <h1 class="text-2xl font-semibold text-gray-800">Thank you for your feedback!</h1>
        <p class="text-gray-700 text-center">Your responses have been recorded anonymously</p>
        <button @click="showResults = !showResults" class="bg-white text-purple-600 rounded-full px-4 py-2 text-sm font-medium hover:bg-purple-100 transition-colors">
          View aggregated results
        </button>
      </div>
      <div v-if="showResults" class="rounded-2xl shadow-lg p-8 bg-gray-50 mt-4 w-full">
        <h2 class="text-xl font-semibold text-gray-800 mb-4">Survey Results</h2>
        <p class="text-gray-600 mb-4">Average ratings for each question (scale: 1-5)</p>
        <div class="space-y-2">
          <div class="flex items-center justify-between">
            <span class="text-gray-700">I feel comfortable sharing my ideas with the team.</span>
            <div class="flex items-center space-x-2">
              <div class="bg-gray-300 h-2 rounded-full w-32">
                <div class="bg-purple-600 h-2 rounded-full" style="width: 84%"></div>
              </div>
              <span class="text-purple-600 font-medium">4.2</span>
            </div>
          </div>
          <div class="flex items-center justify-between">
            <span class="text-gray-700">Team meetings are productive and well-organized.</span>
            <div class="flex items-center space-x-2">
              <div class="bg-gray-300 h-2 rounded-full w-32">
                <div class="bg-purple-600 h-2 rounded-full" style="width: 74%"></div>
              </div>
              <span class="text-purple-600 font-medium">3.7</span>
            </div>
          </div>
          <div class="flex items-center justify-between">
            <span class="text-gray-700">I receive constructive feedback from my teammates.</span>
            <div class="flex items-center space-x-2">
              <div class="bg-gray-300 h-2 rounded-full w-32">
                <div class="bg-purple-600 h-2 rounded-full" style="width: 78%"></div>
              </div>
              <span class="text-purple-600 font-medium">3.9</span>
            </div>
          </div>
          <div class="flex items-center justify-between">
            <span class="text-gray-700">Our team effectively resolves conflicts.</span>
            <div class="flex items-center space-x-2">
              <div class="bg-gray-300 h-2 rounded-full w-32">
                <div class="bg-purple-600 h-2 rounded-full" style="width: 70%"></div>
              </div>
              <span class="text-purple-600 font-medium">3.5</span>
            </div>
          </div>
          <div class="flex items-center justify-between">
            <span class="text-gray-700">I have the resources I need to do my job effectively.</span>
            <div class="flex items-center space-x-2">
              <div class="bg-gray-300 h-2 rounded-full w-32">
                <div class="bg-purple-600 h-2 rounded-full" style="width: 80%"></div>
              </div>
              <span class="text-purple-600 font-medium">4.0</span>
            </div>
          </div>
        </div>
      </div>
      <button class="mt-4 bg-purple-600 text-white rounded-full px-6 py-3 text-sm font-medium hover:bg-purple-700 transition-colors">Return to Home</button>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
