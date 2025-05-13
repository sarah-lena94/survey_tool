<script setup lang="ts">
import { ref, nextTick } from 'vue';
import MainLayout from '../components/layout/MainLayout.vue';
import Header from '../components/layout/Header.vue';
import Footer from '../components/layout/Footer.vue';
import Card from '../components/ui/Card.vue';
import Input from '../components/ui/Input.vue';
import Label from '../components/ui/Label.vue';
import Textarea from '../components/ui/Textarea.vue';
import Button from '../components/ui/Button.vue';
import { Plus, Trash2 } from 'lucide-vue-next';
import { surveyService } from '../api/services/surveyService';
import type { SurveyDto } from '../types/survey';

const title = ref('');
const questions = ref([
  ref({ id: '', text: '', scale: '1-5', position: 0 }),
  ref({ id: '', text: '', scale: '1-5', position: 1 }),
  ref({ id: '', text: '', scale: '1-5', position: 2 }),
  ref({ id: '', text: '', scale: '1-5', position: 3 }),
  ref({ id: '', text: '', scale: '1-5', position: 4 }),
]);

const addQuestion = () => {
  if (questions.value.length < 10) {
    questions.value.push(ref({ id: '', text: '', scale: '1-5', position: questions.value.length }));
  }
};

const removeQuestion = (index: number) => {
  if (questions.value.length > 1) {
    questions.value.splice(index, 1);
    // Update the position of the remaining questions
    questions.value.forEach((question, i) => {
      question.value.position = i;
    });
  }
};

const createSurvey = async () => {
  try {
    await nextTick();
    // Log the title value to verify it's not empty
    console.log('Survey title:', title.value);
    console.log('Questions array:', questions.value);

    const surveyData: SurveyDto = {
      title: title.value,
      createdAt: new Date().toISOString(),
      isTemplate: false,
      questions: questions.value.map((q, index) => {
        console.log('Question text:', q.value.text);
        return {
          id: '',
          surveyId: '',
          text: q.value.text,
          scale: q.value.scale,
          position: index,
        };
      }),
    };

    // Log the complete survey data being sent
    console.log('Survey data being sent:', surveyData);

    const createdSurvey = await surveyService.create(surveyData);

    // Hier sollte die Logik zum Senden der Fragen an das Backend stehen
    // Angenommen, die Fragen werden separat über eine andere API hinzugefügt
    console.log('Survey created successfully:', createdSurvey);

    // Nach erfolgreichem Senden der Daten
    alert('Survey created successfully!');
  } catch (error) {
    console.error('Error creating survey:', error);
    alert('Failed to create survey.');
  }
};
</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8 max-w-4xl">
      <div class="mb-8">
        <a href="/" class="text-teal-600 hover:text-purple-600 transition-colors flex items-center gap-1">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="h-4 w-4"><path d="m12 19-7-7 7-7"/><path d="M19 12H5"/></svg>
          Back to Home
        </a>
      </div>

      <div class="space-y-2 mb-8 text-center">
        <div class="inline-block bg-gradient-to-r from-teal-100 to-purple-100 px-4 py-1 rounded-full text-teal-700 font-medium text-sm mb-2">
          Create Your Survey
        </div>
        <h1 class="text-3xl font-bold tracking-tighter bg-gradient-to-r from-teal-600 to-purple-600 bg-clip-text text-transparent">
          Design Your Team Survey
        </h1>
        <p class="text-gray-600">Customize your questions and response scales to get the insights you need</p>
      </div>

      <form @submit.prevent="createSurvey">
        <Card class="mb-8 rounded-2xl shadow-md hover:shadow-lg transition-all duration-300 border-teal-100">
          <div class="bg-gradient-to-r from-teal-50 to-teal-100/30 rounded-t-2xl p-4">
            <h2 class="text-teal-800 font-bold">Survey Details</h2>
            <p class="text-gray-600">Enter the title and description for your survey</p>
          </div>
          <div class="p-6">
            <div class="space-y-4">
              <div class="space-y-2">
                <Label for="title">Survey Title</Label>
                <Input id="title" placeholder="Enter survey title" v-model:value="title" required class="border-teal-200 focus:border-teal-400 focus:ring-teal-400 transition-all duration-300" />
              </div>
              <div class="space-y-2">
                <Label for="description">Survey Description (Optional)</Label>
                <Textarea id="description" placeholder="Enter a brief description of your survey" class="min-h-[100px] border-teal-200 focus:border-teal-400 focus:ring-teal-400 transition-all duration-300"></Textarea>
              </div>
            </div>
          </div>
        </Card>

        <Card class="mb-8 rounded-2xl shadow-md hover:shadow-lg transition-all duration-300 border-purple-100">
          <div class="bg-gradient-to-r from-purple-50 to-purple-100/30 rounded-t-2xl p-4">
            <h2 class="text-purple-800 font-bold">Survey Questions</h2>
            <p class="text-gray-600">Add up to 10 questions for your survey</p>
          </div>
          <div class="p-6">
            <div class="space-y-6">
              <div v-for="(question, index) in questions" :key="index" class="space-y-4 p-6 border rounded-2xl relative bg-gradient-to-r from-white to-purple-50/30 border-purple-100 hover:border-purple-200 transition-all duration-300">
                <div class="absolute top-4 right-4">
                  <Button type="button" variant="ghost" size="sm" @click="removeQuestion(index)" :disabled="questions.values.length <= 1" class="hover:text-red-500 transition-colors">
                    <Trash2 class="h-4 w-4 text-gray-500" />
                  </Button>
                </div>
                <div class="space-y-2">
                  <div class="flex items-center gap-2">
                    <div class="bg-gradient-to-r from-purple-400 to-purple-500 text-white w-6 h-6 rounded-full flex items-center justify-center text-xs font-medium">
                      {{ index + 1 }}
                    </div>
                    <Label :for="`question-${index}`" class="font-medium text-purple-800">
                      Question {{ index + 1 }}
                    </Label>
                  </div>
                  <Textarea :id="`question-${index}`" placeholder="Enter your question" v-model="question.value.text" required class="border-purple-200 focus:border-purple-400 focus:ring-purple-400 transition-all duration-300" />
                </div>
                <div class="space-y-2">
                  <Label :for="`scale-${index}`">Response Scale</Label>
                  <select :id="`scale-${index}`" v-model="question.value.scale" class="border-purple-200 focus:border-purple-400 focus:ring-purple-400 transition-all duration-300">
                    <option value="1-5">1-5 Scale</option>
                    <option value="1-10">1-10 Scale</option>
                    <option value="emoji">Emoji Scale</option>
                    <option value="agreement">Agreement Scale</option>
                  </select>
                </div>
              </div>
              <Button type="button" variant="outline" class="w-full border-dashed border-purple-300 text-purple-600 rounded-full hover:bg-purple-50 hover:border-purple-400 transition-all duration-300" @click="addQuestion" :disabled="questions.values.length >= 10">
                <Plus class="mr-2 h-4 w-4" />
                Add Question
              </Button>
            </div>
          </div>
        </Card>

        <Button type="submit" class="w-full bg-teal-600 hover:bg-teal-700 rounded-full shadow-md hover:shadow-lg transition-all duration-300 py-6 text-lg">
          Create Survey
        </Button>
      </form>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
