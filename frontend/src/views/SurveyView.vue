<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { surveyService } from '../api/services/surveyService';
import { responseService } from '../api/services/responseService';
import { answerService } from '../api/services/answerService';
import type { AnswerDto } from '../types/answer';
import type { ResponseDto } from '../types/response';

const selectedAnswer = ref('');
const answers = ref<Map<string, string>>(new Map());
import Footer from '../components/layout/Footer.vue';
import Header from '../components/layout/Header.vue';
import MainLayout from '../components/layout/MainLayout.vue';
import Card from '../components/ui/Card.vue';
import Button from '../components/ui/Button.vue';
import Progress from '../components/ui/Progress.vue';
import type { Survey, Question } from '../types/survey';

const route = useRoute();
const surveyId = ref(route.params.id as string);
const survey = ref<Survey | null>(null);
const currentQuestionIndex = ref(0);
const currentQuestion = ref<Question | null>(null);
const router = useRouter();

onMounted(async () => {
  try {
    survey.value = await surveyService.getById(surveyId.value);
    if (survey.value && survey.value.questions && survey.value.questions.length > 0) {
      currentQuestion.value = survey.value.questions[currentQuestionIndex.value];
    }
  } catch (error) {
    console.error('Failed to fetch survey:', error);
  }
});

const submitSurvey = async () => {
  try {
    // Save the last answer
    if (currentQuestion.value && selectedAnswer.value) {
      answers.value.set(currentQuestion.value.id, selectedAnswer.value);
    }

    // Create a response
    const responseDto: ResponseDto = {
      surveyId: surveyId.value,
      submittedAt: new Date().toISOString()
    };

    const response = await responseService.create(responseDto);
    console.log('Response created:', response);

    // Create answers for each question
    const savePromises = Array.from(answers.value.entries()).map(async ([questionId, answer]) => {
      const answerDto: AnswerDto = {
        responseId: response.id,
        questionId: questionId,
        rating: getNumericRating(answer),
        textAnswer: answer
      };

      return answerService.create(answerDto);
    });

    await Promise.all(savePromises);
    console.log('All answers saved successfully!');

    router.push(`/survey/${surveyId.value}/confirmation`);
  } catch (error) {
    console.error('Failed to submit survey:', error);
    alert('Failed to submit survey. Please try again.');
  }
};

const getNumericRating = (answer: string): number => {
  switch (answer) {
    case 'strongly_disagree': return 1;
    case 'disagree': return 2;
    case 'neutral': return 3;
    case 'agree': return 4;
    case 'strongly_agree': return 5;
    default: return 3; // Default to neutral
  }
};

const nextQuestion = () => {
  // Save the current answer before moving to the next question
  if (currentQuestion.value && selectedAnswer.value) {
    answers.value.set(currentQuestion.value.id, selectedAnswer.value);
  }

  selectedAnswer.value = '';
  if (survey.value && survey.value.questions && currentQuestionIndex.value < survey.value.questions.length - 1) {
    currentQuestionIndex.value++;
    currentQuestion.value = survey.value.questions[currentQuestionIndex.value];

    // If we already have an answer for this question, restore it
    if (currentQuestion.value && answers.value.has(currentQuestion.value.id)) {
      selectedAnswer.value = answers.value.get(currentQuestion.value.id) || '';
    }
  } else {
    submitSurvey();
  }
};
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

        <div class="flex items-center justify-between">
              <p>Question {{ currentQuestionIndex + 1 }} of {{ survey.questions ? survey.questions.length : 0 }}</p>
              <p>{{ survey.questions && survey.questions.length === 1 ? (selectedAnswer ? 100 : 0) : (survey.questions && survey.questions.length > 0 ? Math.round((currentQuestionIndex / (survey.questions.length -1)) * 100) : 0) }}% complete</p>
            </div>
            <Progress :value="survey.questions && survey.questions.length === 1 ? (selectedAnswer ? 100 : 0) : (survey.questions && survey.questions.length > 0 ? (currentQuestionIndex / (survey.questions.length -1)) * 100 : 0)" />

        <Card v-if="currentQuestion">
          <h2>{{currentQuestion.text}}</h2>
          <p>Select your response below</p>
          <div>
            <label>
              <input type="radio" name="answer" value="strongly_disagree" v-model="selectedAnswer" />
              Strongly disagree
            </label>
            <label>
              <input type="radio" name="answer" value="disagree" v-model="selectedAnswer" />
              Disagree
            </label>
            <label>
              <input type="radio" name="answer" value="neutral" v-model="selectedAnswer" />
              Neutral
            </label>
            <label>
              <input type="radio" name="answer" value="agree" v-model="selectedAnswer" />
              Agree
            </label>
            <label>
              <input type="radio" name="answer" value="strongly_agree" v-model="selectedAnswer" />
              Strongly agree
            </label>
          </div>
        </Card>
        <div class="flex justify-between">
          <Button variant="outline">Back</Button>
          <Button :disabled="!selectedAnswer" @click="nextQuestion">{{ currentQuestionIndex + 1 === survey.questions?.length ? 'Submit' : 'Next' }}</Button>
        </div>
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
