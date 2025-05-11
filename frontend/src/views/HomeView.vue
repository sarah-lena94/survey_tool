<script setup lang="ts">
import { RouterLink } from 'vue-router'
import Button from '../components/ui/Button.vue'
import MainLayout from '../components/layout/MainLayout.vue'
import Header from '../components/layout/Header.vue'
import Footer from '../components/layout/Footer.vue'
</script>

<template>
  <MainLayout>
    <template #header>
      <Header />
    </template>
    <section class="w-full py-12 md:py-24 lg:py-32 bg-gradient-to-b from-white via-teal-50 to-purple-50 relative overflow-hidden">
      <!-- Decorative elements -->
      <div class="absolute top-20 left-10 w-64 h-64 bg-orange-200 rounded-full mix-blend-multiply filter blur-3xl opacity-20 animate-float"></div>
      <div
        class="absolute bottom-20 right-10 w-64 h-64 bg-purple-200 rounded-full mix-blend-multiply filter blur-3xl opacity-20 animate-float"
        style="animation-delay: 2s"
      ></div>

      <div class="container px-4 md:px-6 relative">
        <div class="flex flex-col items-center justify-center space-y-6 text-center">
          <div class="space-y-3">
            <h1 class="text-3xl font-bold tracking-tighter sm:text-4xl md:text-5xl lg:text-6xl/none bg-gradient-to-r from-teal-600 to-purple-600 bg-clip-text text-transparent">
              Get feedback. Improve teamwork.
            </h1>
            <p class="mx-auto max-w-[700px] text-gray-600 md:text-xl">
              Create quick surveys and get anonymous insights from your team.
            </p>
          </div>
          <div class="flex flex-col sm:flex-row gap-4 min-[400px]:flex-row">
            <RouterLink to="/surveys/participate">
              <Button
                size="lg"
                class="bg-gradient-to-r from-teal-500 to-teal-600 hover:from-teal-600 hover:to-teal-700 rounded-full shadow-md hover:shadow-lg transition-all duration-300 px-8"
              >
                Start Survey
              </Button>
            </RouterLink>
            <RouterLink to="/create">
              <Button
                size="lg"
                variant="outline"
                class="border-teal-300 text-teal-700 hover:bg-teal-50 rounded-full transition-all duration-300 px-8"
              >
                Create Survey
              </Button>
            </RouterLink>
          </div>
        </div>
        <!-- Rest of the content -->
      </div>
    </section>
    <!-- Additional sections -->
    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
