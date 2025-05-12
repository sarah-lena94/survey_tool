<script setup lang="ts">
import MainLayout from '../components/layout/MainLayout.vue';
import Header from '../components/layout/Header.vue';
import Footer from '../components/layout/Footer.vue';
import Card from '../components/ui/Card.vue';
import Button from '../components/ui/Button.vue';
import Progress from '../components/ui/Progress.vue';
</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>

    <div class="container mx-auto px-4 py-8 max-w-3xl">
      <h1>Team Collaboration Survey</h1>
      <p>Your feedback is anonymous and helps improve teamwork.</p>

      <Progress :value="20" />
      <p>Question 1 of 5</p>

      <Card>
        <h2>I feel comfortable sharing my ideas with the team.</h2>
        <p>Select your response below</p>
        <div>
          <label>
            <input type="radio" name="answer" value="strongly_disagree">
            Strongly disagree
          </label>
          <label>
            <input type="radio" name="answer" value="disagree">
            Disagree
          </label>
          <label>
            <input type="radio" name="answer" value="neutral">
            Neutral
          </label>
          <label>
            <input type="radio" name="answer" value="agree">
            Agree
          </label>
          <label>
            <input type="radio" name="answer" value="strongly_agree">
            Strongly agree
          </label>
        </div>
      </Card>

      <div class="flex justify-between">
        <Button variant="outline">Back</Button>
        <Button>Next</Button>
      </div>
    </div>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
