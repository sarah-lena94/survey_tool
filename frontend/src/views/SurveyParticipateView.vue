<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { RouterLink, useRouter } from 'vue-router';
import { surveyService } from '../api/services/surveyService';
import MainLayout from '../components/layout/MainLayout.vue';
import Button from '../components/ui/Button.vue';
import Input from '../components/ui/Input.vue';
import Footer from '../components/layout/Footer.vue';
import Header from '../components/layout/Header.vue';

const surveyCode = ref('');
const router = useRouter();

import type { Survey } from 'src/types/survey.ts';

const survey1 = ref<Survey | null>(null);
const survey2 = ref<Survey | null>(null);
const survey3 = ref<Survey | null>(null);

onMounted(async () => {
  survey1.value = await surveyService.getById('cf3cad35-5810-42a3-b10e-ec7b16e41fe4') || null;
  survey2.value = await surveyService.getById('4c7f2a5a-6b7c-4d7e-bc25-9b7e0e1e6d2a') || null;
  survey3.value = await surveyService.getById('7b9e0e1e-6d2a-4c7f-2a5a-6b7c4d7ebc25') || null;
});

const startSurvey = () => {
  if (surveyCode.value) {
    router.push(`/survey/${surveyCode.value}`);
  } else {
    alert('Please enter a survey code.');
  }
};
</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container flex justify-center items-center flex-col m-auto px-4 py-8">
      <div class="container max-w-4xl">
        <RouterLink to="/" class="text-teal-500 hover:text-teal-700 flex items-center mb-4">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-5 h-5 mr-2">
            <path fill-rule="evenodd"
              d="M17 10a.75.75 0 01-.75.75H5.612l4.158 3.96a.75.75 0 11-1.04 1.08l-5.5-5.25a.75.75 0 010-1.08l5.5-5.25a.75.75 0 111.04 1.08L5.612 9.25H16.25A.75.75 0 0117 10z"
              clip-rule="evenodd" />
          </svg>
          Back to Home
        </RouterLink>

        <div class="flex justify-center items-center flex-col w-full">
          <div class="text-center mb-8">
            <div class="inline-block bg-gradient-to-r from-teal-100 to-purple-100 px-4 py-1 rounded-full text-teal-700 font-medium text-sm mb-2">
              Join Survey
            </div>
            <h1 class="text-3xl font-bold text-gray-800 mb-2" style="color: #4338ca;">Participate in a Survey</h1>
            <p class="text-gray-600 text-lg">Enter a survey code or select from available surveys</p>
          </div>

          <div class="grid grid-cols-1 md:grid-cols-2 gap-6 max-w-5xl mx-auto">
            <div class="rounded-2xl shadow-sm overflow-hidden border border-gray-100">
              <div class="bg-gradient-to-br from-teal-50 to-teal-100 p-6">
                <h2 class="text-xl font-semibold text-teal-700 mb-3">Enter Survey Code</h2>
                <p class="text-gray-600 mb-5">Enter the code provided by your team leader</p>
              </div>

              <div class="bg-white p-6">
                <div class="mb-4">
                  <div class="text-sm font-medium text-gray-700 mb-2">Survey Code</div>
                  <Input
                    type="text"
                    placeholder="Enter survey code"
                    class="rounded-lg border-gray-200 h-11 focus:border-teal-300 focus:ring focus:ring-teal-200 focus:ring-opacity-50"
                    :value="surveyCode"
                    @update:value="surveyCode = $event"
                  />
                </div>

                <Button
                  class="bg-teal-500 hover:bg-teal-600 text-white rounded-full py-2.5 px-6 w-full shadow-sm font-medium transition-colors duration-300"
                  @click="startSurvey"
                >
                  Start Survey
                </Button>
              </div>
            </div>

            <div class="rounded-2xl shadow-sm overflow-hidden border border-gray-100">
              <div class="bg-gradient-to-br from-purple-50 to-purple-100 p-6">
                <h2 class="text-xl font-semibold text-purple-700 mb-3">Available Surveys</h2>
                <p class="text-gray-600 mb-0">Select from the list of available surveys</p>
              </div>

              <div class="bg-white p-5">
                <div class="space-y-5">
                  <RouterLink v-if="survey1" :to="'/survey/' + survey1.id" class="block">
                    <div class="bg-white rounded-lg border border-gray-100 hover:shadow-md transition-all duration-300 overflow-hidden cursor-pointer">
                      <div class="p-5">
                        <h3 class="text-lg font-semibold text-gray-800 mb-2">{{ survey1.title }}</h3>
                        <div class="flex items-center text-sm text-gray-500">
                          <div class="flex items-center mr-4">
                            <svg class="w-4 h-4 mr-1.5 text-purple-400" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                              <rect width="18" height="18" x="3" y="3" rx="2" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <path d="M7 9h10M7 13h10M7 17h5" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                            </svg>
                            <span>{{ survey1.questions?.length }} questions</span>
                          </div>
                          <div class="flex items-center">
                            <svg class="w-4 h-4 mr-1.5 text-teal-400" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                              <rect width="18" height="18" x="3" y="3" rx="2" stroke="currentColor" stroke-width="2" />
                              <path d="M3 9h18" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <path d="M8 2v3M16 2v3" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <circle cx="8" cy="14" r="1" fill="currentColor" />
                              <circle cx="12" cy="14" r="1" fill="currentColor" />
                              <circle cx="16" cy="14" r="1" fill="currentColor" />
                            </svg>
                            <span>{{ survey1.createdAt || '13.05.2025' }}</span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </RouterLink>

                  <RouterLink v-if="survey2" :to="'/survey/' + survey2.id" class="block">
                    <div class="bg-white rounded-lg border border-gray-100 hover:shadow-md transition-all duration-300 overflow-hidden cursor-pointer">
                      <div class="p-5">
                        <h3 class="text-lg font-semibold text-gray-800 mb-2">{{ survey2.title }}</h3>
                        <div class="flex items-center text-sm text-gray-500">
                          <div class="flex items-center mr-4">
                            <svg class="w-4 h-4 mr-1.5 text-purple-400" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                              <rect width="18" height="18" x="3" y="3" rx="2" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <path d="M7 9h10M7 13h10M7 17h5" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                            </svg>
                            <span>{{ survey2.questions?.length }} questions</span>
                          </div>
                          <div class="flex items-center">
                            <svg class="w-4 h-4 mr-1.5 text-teal-400" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                              <rect width="18" height="18" x="3" y="3" rx="2" stroke="currentColor" stroke-width="2" />
                              <path d="M3 9h18" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <path d="M8 2v3M16 2v3" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <circle cx="8" cy="14" r="1" fill="currentColor" />
                              <circle cx="12" cy="14" r="1" fill="currentColor" />
                              <circle cx="16" cy="14" r="1" fill="currentColor" />
                            </svg>
                            <span>{{ survey2.createdAt || '10.05.2025' }}</span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </RouterLink>

                  <RouterLink v-if="survey3" :to="'/survey/' + survey3.id" class="block">
                    <div class="bg-white rounded-lg border border-gray-100 hover:shadow-md transition-all duration-300 overflow-hidden cursor-pointer">
                      <div class="p-5">
                        <h3 class="text-lg font-semibold text-gray-800 mb-2">{{ survey3.title }}</h3>
                        <div class="flex items-center text-sm text-gray-500">
                          <div class="flex items-center mr-4">
                            <svg class="w-4 h-4 mr-1.5 text-purple-400" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                              <rect width="18" height="18" x="3" y="3" rx="2" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <path d="M7 9h10M7 13h10M7 17h5" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                            </svg>
                            <span>{{ survey3.questions?.length }} questions</span>
                          </div>
                          <div class="flex items-center">
                            <svg class="w-4 h-4 mr-1.5 text-teal-400" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                              <rect width="18" height="18" x="3" y="3" rx="2" stroke="currentColor" stroke-width="2" />
                              <path d="M3 9h18" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <path d="M8 2v3M16 2v3" stroke="currentColor" stroke-width="2" stroke-linecap="round" />
                              <circle cx="8" cy="14" r="1" fill="currentColor" />
                              <circle cx="12" cy="14" r="1" fill="currentColor" />
                              <circle cx="16" cy="14" r="1" fill="currentColor" />
                            </svg>
                            <span>{{ survey3.createdAt || '11.05.2025' }}</span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </RouterLink>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
