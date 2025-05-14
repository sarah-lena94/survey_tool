<script setup lang="ts">
import Results from '../components/ui/Results.vue';
import MainLayout from '../components/layout/MainLayout.vue';
import Header from '../components/layout/Header.vue';
import Footer from '../components/layout/Footer.vue';
import { ref, onMounted } from 'vue';
import { RouterLink, useRoute } from 'vue-router';
import { surveyService } from '../api/services/surveyService';
import type { SurveyResultDto } from '../types/survey.ts';

const showResults = ref(false);
const route = useRoute();
const surveyId = ref<string | null>(null);
const surveyResults = ref<SurveyResultDto[]>([]);

onMounted(async () => {
  surveyId.value = route.params.id as string;
  if (surveyId.value) {
    try {
      surveyResults.value = await surveyService.getSurveyResults(surveyId.value);
    } catch (error) {
      console.error('Error fetching survey results:', error);
    }
  }
});

</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8 max-w-3xl flex flex-col items-center">
      <div
        class="rounded-2xl shadow-lg p-8 bg-gradient-to-br from-teal-50 to-purple-50 flex flex-col items-center space-y-4">
        <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 24 24" fill="none" stroke="#A855F7"
          stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
          <path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"></path>
          <polyline points="22 4 12 14.01 9 11.01"></polyline>
        </svg>
        <h1 class="text-2xl font-semibold text-gray-800">Thank you for your feedback!</h1>
        <p class="text-gray-700 text-center">Your responses have been recorded anonymously</p>
        <button @click="showResults = !showResults"
          class="bg-white text-purple-600 rounded-full px-4 py-2 text-sm font-medium hover:bg-purple-100 transition-colors">
          View aggregated results
        </button>
      </div>
      <Results v-if="showResults" :surveyResults="surveyResults" />
      <RouterLink to="/">
        <button
          class="mt-4 bg-purple-600 text-white rounded-full px-6 py-3 text-sm font-medium hover:bg-purple-700 transition-colors">Return
          to Home</button>
      </RouterLink>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
