<script setup lang="ts">
import { RouterLink } from 'vue-router'
import Button from '../components/ui/Button.vue'
import MainLayout from '../components/layout/MainLayout.vue'
import Header from '../components/layout/Header.vue'
import Footer from '../components/layout/Footer.vue'
</script>

<template>
  <MainLayout class="flex flex-col justify-center">
    <template #header>
      <Header />
    </template>

      <!-- Hero Section -->
      <section class="flex flex-col justify-center items-center w-full py-16 md:py-24 lg:py-32 bg-gradient-to-b from-white via-blue-100/50 to-purple-100/50">
        <div class="container w-full flex flex-col justify-center mx-auto px-4 sm:px-6 lg:px-8">
          <div class="w-full flex flex-col items-center justify-center space-y-8 text-center">
            <div class="w-full space-y-4 max-w-3xl">
              <h1
                class="text-4xl font-bold tracking-tight sm:text-5xl md:text-6xl lg:text-7xl bg-gradient-to-r from-teal-500 via-blue-500 to-purple-600 bg-clip-text text-transparent">
                Get feedback. Improve teamwork.
              </h1>
              <p class="mx-auto max-w-2xl text-gray-600 text-xl md:text-2xl">
                Create quick surveys and get anonymous insights from your team.
              </p>
            </div>
            <div class="flex flex-row gap-6 pt-4">
              <RouterLink to="/survey/participate">
                <Button size="lg"
                  class="bg-teal-500 hover:bg-teal-600 text-white rounded-md shadow-md hover:shadow-lg transition-all duration-300 px-8 py-3 text-lg">
                  Start Survey
                </Button>
              </RouterLink>
              <RouterLink to="/create">
                <Button size="lg" variant="outline"
                  class="border-2 border-teal-300 text-teal-700 hover:bg-teal-50 rounded-md transition-all duration-300 px-8 py-3 text-lg">
                  Create Survey
                </Button>
              </RouterLink>
            </div>
          </div>
        </div>

        <div class="container flex justify-center mx-auto px-4 sm:px-6 lg:px-8 py-12 md:py-16">
          <div class="max-w-6xl mx-auto bg-gray-100 rounded-lg shadow-sm overflow-hidden">
            <div class="aspect-[16/9] flex items-center justify-center bg-gray-50 border border-gray-200">
              <div class="text-gray-300">
                <svg xmlns="http://www.w3.org/2000/svg" width="80" height="80" viewBox="0 0 24 24" fill="none"
                  stroke="currentColor" stroke-width="1" stroke-linecap="round" stroke-linejoin="round">
                  <rect x="3" y="3" width="18" height="18" rx="2" ry="2" />
                  <circle cx="8.5" cy="8.5" r="1.5" />
                  <polyline points="21 15 16 10 5 21" />
                </svg>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- How it works Section -->
      <section class="flex flex-col justify-center items-center w-full py-16 md:py-24 bg-white">
        <div class="container mx-auto px-4 sm:px-6 lg:px-8">
          <div class="flex flex-col items-center justify-center space-y-6 text-center mb-16">
            <div class="inline-block rounded-full bg-teal-100 px-4 py-1.5 text-sm font-medium text-teal-700">
              Simple & Effective
            </div>
            <h2 class="text-4xl font-bold tracking-tight sm:text-5xl md:text-6xl md:py-3">
              <span class="text-blue-600">How it</span> <span class="text-purple-600">works</span>
            </h2>
            <p class="mx-auto max-w-2xl text-gray-600 text-xl md:text-2xl mt-4">
              Simple steps to gather valuable feedback from your team
            </p>
          </div>

          <div class="grid grid-cols-1 md:grid-cols-3 gap-12 mx-auto md:py-16">
            <!-- Create Step -->
            <div class="flex flex-col items-center text-center">
              <div class="h-20 w-20 rounded-full bg-teal-100 flex items-center justify-center mb-6">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24" fill="none"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                  class="text-teal-600">
                  <path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path>
                  <path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path>
                </svg>
              </div>
              <h3 class="text-2xl font-bold text-teal-600 mb-3">Create</h3>
              <p class="text-gray-600 text-lg">
                Design your survey with custom questions in minutes
              </p>
            </div>

            <!-- Share Step -->
            <div class="flex flex-col items-center text-center">
              <div class="h-20 w-20 rounded-full bg-purple-100 flex items-center justify-center mb-6">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24" fill="none"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                  class="text-purple-600">
                  <path d="M4 12v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8"></path>
                  <polyline points="16 6 12 2 8 6"></polyline>
                  <line x1="12" y1="2" x2="12" y2="15"></line>
                </svg>
              </div>
              <h3 class="text-2xl font-bold text-purple-600 mb-3">Share</h3>
              <p class="text-gray-600 text-lg">
                Send the survey link to your team members with one click
              </p>
            </div>

            <!-- Analyze Step -->
            <div class="flex flex-col items-center text-center">
              <div class="h-20 w-20 rounded-full bg-orange-100 flex items-center justify-center mb-6">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24" fill="none"
                  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                  class="text-orange-600">
                  <line x1="18" y1="20" x2="18" y2="10"></line>
                  <line x1="12" y1="20" x2="12" y2="4"></line>
                  <line x1="6" y1="20" x2="6" y2="14"></line>
                </svg>
              </div>
              <h3 class="text-2xl font-bold text-orange-600 mb-3">Analyze</h3>
              <p class="text-gray-600 text-lg">
                Review insights and improve your team dynamics
              </p>
            </div>
          </div>
        </div>
      </section>

      <!-- Testimonials Section -->
      <section class="flex flex-col justify-center items-center w-full py-16 md:py-24 bg-gradient-to-b from-white to-purple-100/50">
        <div class="container mx-auto px-4 sm:px-6 lg:px-8">
          <div class="flex flex-col items-center justify-center space-y-6 text-center mb-16">
            <div class="inline-block rounded-full bg-purple-100 px-4 py-1.5 text-sm font-medium text-purple-700">
              What Teams Say
            </div>
            <h2 class="text-4xl font-bold tracking-tight sm:text-5xl md:text-6xl md:py-2">
              <span class="bg-gradient-to-r from-blue-600 to-purple-600 bg-clip-text text-transparent">Loved by teams
                everywhere</span>
            </h2>
          </div>

          <div class="grid grid-cols-1 md:grid-cols-3 gap-10 mx-auto md:py-8">
            <!-- Testimonial 1 -->
            <div class="flex flex-col p-8 bg-white rounded-xl border border-gray-100 shadow-sm">
              <div class="flex items-center gap-4 mb-6">
                <div
                  class="h-16 w-16 rounded-full bg-purple-200 flex items-center justify-center text-purple-700 font-bold text-xl">
                  AB
                </div>
                <div>
                  <h4 class="font-bold text-lg">Alex Brown</h4>
                  <p class="text-sm text-gray-500">Product Manager</p>
                </div>
              </div>
              <p class="text-gray-600 mb-6 text-lg leading-relaxed">
                "Teammeter helped us identify communication gaps in our remote team that we didn't even know existed!"
              </p>
              <div class="flex text-purple-500">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
              </div>
            </div>

            <!-- Testimonial 2 -->
            <div class="flex flex-col p-8 bg-white rounded-xl border border-gray-100 shadow-sm">
              <div class="flex items-center gap-4 mb-6">
                <div
                  class="h-16 w-16 rounded-full bg-teal-200 flex items-center justify-center text-teal-700 font-bold text-xl">
                  SJ
                </div>
                <div>
                  <h4 class="font-bold text-lg">Sarah Johnson</h4>
                  <p class="text-sm text-gray-500">Team Lead</p>
                </div>
              </div>
              <p class="text-gray-600 mb-6 text-lg leading-relaxed">
                "The anonymous feedback feature has been a game-changer for our team's psychological safety."
              </p>
              <div class="flex text-teal-500">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
              </div>
            </div>

            <!-- Testimonial 3 -->
            <div class="flex flex-col p-8 bg-white rounded-xl border border-gray-100 shadow-sm">
              <div class="flex items-center gap-4 mb-6">
                <div
                  class="h-16 w-16 rounded-full bg-orange-200 flex items-center justify-center text-orange-700 font-bold text-xl">
                  MP
                </div>
                <div>
                  <h4 class="font-bold text-lg">Michael Patel</h4>
                  <p class="text-sm text-gray-500">Engineering Director</p>
                </div>
              </div>
              <p class="text-gray-600 mb-6 text-lg leading-relaxed">
                "We run monthly pulse surveys now and our team engagement has improved dramatically!"
              </p>
              <div class="flex text-orange-500">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="currentColor"
                  class="mr-1">
                  <polygon
                    points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2">
                  </polygon>
                </svg>
              </div>
            </div>
          </div>
        </div>
      </section>

    <template #footer>
      <Footer />
    </template>
  </MainLayout>
</template>
