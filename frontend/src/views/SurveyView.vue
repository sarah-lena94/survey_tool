<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import MainLayout from '@/components/layout/MainLayout.vue';
import Header from '@/components/layout/Header.vue';
import Footer from '@/components/layout/Footer.vue';
import Card from '@/components/ui/Card.vue';
import Button from '@/components/ui/Button.vue';
import { surveyService } from '@/api/services/surveyService';
import type { Survey } from '@/types/survey';

const route = useRoute();
const surveyId = ref(route.params.id as string);
const survey = ref<Survey | null>(null);

onMounted(async () => {
  try {
    survey.value = await surveyService.getById(surveyId.value);
  } catch (error) {
    console.error('Failed to fetch survey:', error);
  }
});
</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8 max-w-3xl">
      <div class="mb-8">
        <a href="/" class="text-teal-600 hover:text-purple-600 transition-colors flex items-center gap-1">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="h-4 w-4"><path d="m12 19-7-7 7-7"/><path d="M19 12H5"/></svg>
          Back to Home
        </a>
      </div>

      <div v-if="survey" class="space-y-4">
        <h1 class="text-3xl font-bold tracking-tighter bg-gradient-to-r from-teal-600 to-purple-600 bg-clip-text text-transparent">
          {{ survey.title }}
        </h1>
        <p class="text-gray-600">Take a moment to share your feedback</p>

        <Card>
          <p>Survey ID: {{ survey.id }}</p>
          <!-- Implement survey questions here -->
        </Card>
      </div>
      <div v-else>
        Loading survey...
      </div>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
