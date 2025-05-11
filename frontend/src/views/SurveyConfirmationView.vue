<script setup lang="ts">
import MainLayout from '../components/layout/MainLayout.vue';
import Header from '../components/layout/Header.vue';
import Footer from '../components/layout/Footer.vue';
</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8 max-w-3xl">
      <h1>Survey Confirmation</h1>
      <p>Thank you for submitting the survey!</p>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
