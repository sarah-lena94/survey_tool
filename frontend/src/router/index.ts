import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/create',
      name: 'create',
      component: () => import('../views/CreateSurveyView.vue')
    },
    {
      path: '/survey/:id',
      name: 'survey',
      component: () => import('../views/SurveyView.vue')
    },
    {
      path: '/survey/:id/results',
      name: 'survey-results',
      component: () => import('../views/SurveyResultsView.vue')
    },
    {
      path: '/survey/:id/confirmation',
      name: 'survey-confirmation',
      component: () => import('../views/SurveyConfirmationView.vue')
    },
    {
      path: '/survey/participate',
      name: 'survey-participate',
      component: () => import('../views/SurveyParticipateView.vue')
    },
{
      path: '/survey/:id/success',
      name: 'survey-creation-success',
      component: () => import('../views/SurveyCreationSuccessView.vue')
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    }
  ],
});

export default router;
