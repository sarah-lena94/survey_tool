<script setup lang="ts">
import { ref } from 'vue';
import MainLayout from '@/components/layout/MainLayout.vue';
import Header from '@/components/layout/Header.vue';
import Footer from '@/components/layout/Footer.vue';
import Input from '@/components/ui/Input.vue';
import Button from '@/components/ui/Button.vue';

const surveyId = ref('');
</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8 max-w-3xl">
      <h1>Survey Participation</h1>
      <p>Enter the survey ID to participate:</p>
      <Input type="text" v-model="surveyId" placeholder="Survey ID" />
      <Button>Start Survey</Button>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
