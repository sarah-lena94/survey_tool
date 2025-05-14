<script setup lang="ts">
import MainLayout from '../components/layout/MainLayout.vue';
import Header from '../components/layout/Header.vue';
import Footer from '../components/layout/Footer.vue';
import Button from '../components/ui/Button.vue';
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();
const surveyId = ref<string>('');
const surveyLink = ref<string>('');
const copySuccess = ref<boolean>(false);

onMounted(() => {
  surveyId.value = route.params.id as string;
  surveyLink.value = `${window.location.origin}/survey/${surveyId.value}`;
});

const copyToClipboard = async () => {
  try {
    await navigator.clipboard.writeText(surveyLink.value);
    copySuccess.value = true;
    setTimeout(() => {
      copySuccess.value = false;
    }, 2000);
  } catch (err) {
    console.error('Failed to copy: ', err);
  }
};

const viewSurvey = () => {
  router.push({ name: 'survey', params: { id: surveyId.value } });
};

const viewResults = () => {
  router.push({ name: 'survey-results', params: { id: surveyId.value } });
};
</script>

<style>
.text-teal-700:hover {
  color: white !important;
}
</style>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8 max-w-3xl">
      <div class="bg-gradient-to-r from-teal-50 to-teal-100/30 rounded-3xl p-8 shadow-md flex flex-col items-center">
        <!-- Success Icon -->
        <div class="text-teal-600 mb-6">
          <svg width="64" height="64" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M12 22C17.5228 22 22 17.5228 22 12C22 6.47715 17.5228 2 12 2C6.47715 2 2 6.47715 2 12C2 17.5228 6.47715 22 12 22Z"
              stroke="currentColor" stroke-width="2" />
            <path d="M8 12L11 15L16 9" stroke="currentColor" stroke-width="2" stroke-linecap="round"
              stroke-linejoin="round" />
          </svg>
        </div>

        <!-- Success Message -->
        <h1 class="text-3xl font-bold text-center text-teal-800 mb-4">Survey Created Successfully!</h1>
        <p class="text-gray-600 text-center mb-6">Share this link with your team to collect responses</p>

        <!-- Survey Link -->
        <div class="w-full flex items-center mb-8">
          <input type="text" readonly :value="surveyLink"
            class="flex-grow p-3 border border-teal-200 rounded-l-lg text-gray-700 bg-white" />
          <button @click="copyToClipboard"
            class="bg-teal-600 hover:bg-teal-700 text-white px-6 py-3 rounded-r-lg transition-colors">
            {{ copySuccess ? 'Copied!' : 'Copy' }}
          </button>
        </div>

        <!-- Action Buttons -->
        <div class="flex flex-col sm:flex-row gap-4 w-full">
          <Button @click="viewSurvey" class="flex-1 bg-teal-600 hover:bg-teal-700 text-white rounded-full py-3">
            View Survey
          </Button>
          <Button @click="viewResults"
            class="flex-1 bg-white border border-teal-600 text-teal-700 hover:bg-teal-700 rounded-full py-3">
            View Results
          </Button>
        </div>
      </div>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
