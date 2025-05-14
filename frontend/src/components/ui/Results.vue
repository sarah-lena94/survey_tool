<template>
  <div class="rounded-2xl shadow-lg p-8 bg-gray-50 mt-4 w-full">
    <h2 class="text-xl font-semibold text-gray-800 mb-4">Survey Results: {{ surveyTitle }}</h2>
    <div class="space-y-2" v-if="surveyResults.length > 0">
      <p class="text-gray-600 mt-4">{{ numberOfParticipants }} responses</p>
      <p class="text-gray-600 mb-4">Average ratings for each question (scale: 1-5)</p>
      <div class="flex items-center justify-between" v-for="result in surveyResults" :key="result.questionText">
        <span class="text-gray-700">{{ result.questionText }}</span>
        <div class="flex items-center space-x-2">
          <span class="text-purple-600 font-medium">{{ result.averageAnswer }}</span>
          <div class="bg-gray-300 h-2 rounded-full w-32">
            <div class="bg-purple-600 h-2 rounded-full" :style="{ width: (result.averageAnswer / 5) * 100 + '%' }">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-else>
      <p>No responses yet. No results found.</p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';
import type { SurveyResultDto } from '../../types/survey.ts';
import { ref, onMounted } from 'vue';
import { surveyService } from '../../api/services/surveyService';
const { surveyResults, surveyId, surveyTitle } = defineProps<{
  surveyResults: SurveyResultDto[];
  surveyId: string;
  surveyTitle: string;
}>();
const numberOfParticipants = ref(0);

onMounted(async () => {
  numberOfParticipants.value = await surveyService.getNumberOfParticipants(surveyId);
});
</script>
