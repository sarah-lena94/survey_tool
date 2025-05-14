import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useSurveyStore = defineStore('survey', () => {
  const currentSurveyTitle = ref('')

  function setCurrentSurveyTitle(title: string) {
    currentSurveyTitle.value = title
  }

  return { currentSurveyTitle, setCurrentSurveyTitle }
})
