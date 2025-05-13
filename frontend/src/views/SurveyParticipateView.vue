<script setup lang="ts">
import { ref } from 'vue';
import { useRouter, RouterLink } from 'vue-router';
import Button from '../components/ui/Button.vue';
import Card from '../components/ui/Card.vue';
import Input from '../components/ui/Input.vue';
import MainLayout from '../components/layout/MainLayout.vue';
import Header from '../components/layout/Header.vue';
import Footer from '../components/layout/Footer.vue';

const surveyCode = ref('');
const router = useRouter();

const startSurvey = () => {
  if (surveyCode.value) {
    router.push(`/survey/${surveyCode.value}`);
  } else {
    // Optionally, display an error message if the survey code is empty
    alert('Please enter a survey code.');
  }
};
</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8">
      <RouterLink to="/" class="text-teal-500 hover:text-teal-700 flex items-center mb-4">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-5 h-5 mr-2">
          <path fill-rule="evenodd" d="M15.795 6.105a.75.75 0 010 1.06l-4.5 4.5a.75.75 0 01-1.06 0l-4.5-4.5a.75.75 0 011.06-1.06L10 9.94l3.945-3.94a.75.75 0 011.06 0z" clip-rule="evenodd" />
        </svg>
        Back to Home
      </RouterLink>

      <div class="text-center mb-8">
        <span class="inline-block bg-teal-100 text-teal-600 rounded-full px-3 py-1 text-sm font-semibold mb-2">Join Survey</span>
        <h1 class="text-2xl font-bold text-gray-800">Participate in a Survey</h1>
        <p class="text-gray-600">Enter a survey code or select from available surveys</p>
      </div>

      <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
        <Card class="bg-teal-50">
          <h2 class="text-lg font-semibold text-gray-700 mb-4">Enter Survey Code</h2>
          <p class="text-gray-600 mb-4">Enter the code provided by your team leader</p>
          <Input
            type="text"
            placeholder="Enter survey code"
            class="mb-4"
            :value="surveyCode"
            @update:value="surveyCode = $event"
          />
          <Button class="w-full bg-teal-500 hover:bg-teal-600 text-white rounded-md py-2" @click="startSurvey">Start Survey</Button>
        </Card>

        <Card class="bg-purple-50">
          <h2 class="text-lg font-semibold text-gray-700 mb-4">Available Surveys</h2>
          <p class="text-gray-600 mb-4">Select from the list of available surveys</p>
          <ul>
            <li class="py-2 border-b border-gray-200 last:border-b-0">
              <div class="flex items-center justify-between">
                <div>
                  <h3 class="font-semibold text-gray-700">Team Collaboration Survey</h3>
                  <p class="text-gray-500 text-sm">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-4 h-4 inline-block mr-1">
                      <path d="M3 4a2 2 0 00-2 2v1.11a2 2 0 00.283 1.14l3.758 5.011a.75.75 0 01-.564 1.249l-1.5 1.5a.75.75 0 01-1.061-1.06l1.5-1.5a.75.75 0 011.249-.564l5.011 3.758a2 2 0 001.14.283H16a2 2 0 002-2V6a2 2 0 00-2-2H3z" />
                    </svg>
                    5 questions
                    <span class="mx-1">•</span>
                    10.5.2023
                  </p>
                </div>
                <Button variant="outline">Participate</Button>
              </div>
            </li>
            <li class="py-2 border-b border-gray-200 last:border-b-0">
              <div class="flex items-center justify-between">
                <div>
                  <h3 class="font-semibold text-gray-700">Project Feedback Survey</h3>
                  <p class="text-gray-500 text-sm">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-4 h-4 inline-block mr-1">
                      <path d="M3 4a2 2 0 00-2 2v1.11a2 2 0 00.283 1.14l3.758 5.011a.75.75 0 01-.564 1.249l-1.5 1.5a.75.75 0 01-1.061-1.06l1.5-1.5a.75.75 0 011.249-.564l5.011 3.758a2 2 0 001.14.283H16a2 2 0 002-2V6a2 2 0 00-2-2H3z" />
                    </svg>
                    8 questions
                    <span class="mx-1">•</span>
                    8.5.2023
                  </p>
                </div>
                <Button variant="outline">Participate</Button>
              </div>
            </li>
            <li class="py-2 border-b border-gray-200 last:border-b-0">
              <div class="flex items-center justify-between">
                <div>
                  <h3 class="font-semibold text-gray-700">Work Environment Survey</h3>
                  <p class="text-gray-500 text-sm">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-4 h-4 inline-block mr-1">
                      <path d="M3 4a2 2 0 00-2 2v1.11a2 2 0 00.283 1.14l3.758 5.011a.75.75 0 01-.564 1.249l-1.5 1.5a.75.75 0 01-1.061-1.06l1.5-1.5a.75.75 0 011.249-.564l5.011 3.758a2 2 0 001.14.283H16a2 2 0 002-2V6a2 2 0 00-2-2H3z" />
                    </svg>
                    6 questions
                    <span class="mx-1">•</span>
                    5.5.2023
                  </p>
                </div>
                <Button variant="outline">Participate</Button>
              </div>
            </li>
          </ul>
        </Card>
      </div>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
