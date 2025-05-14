import apiClient from '../client.js'
import type { Survey, SurveyDto, SurveyResultDto } from 'src/types/survey.ts'

export const surveyService = {
  async getAll(): Promise<Survey[]> {
    const response = await apiClient.get<Survey[]>('/surveys')
    return response.data
  },

  async getById(id: string): Promise<Survey> {
    const response = await apiClient.get<Survey>(`/surveys/${id}`)
    return response.data
  },

  async create(survey: SurveyDto): Promise<Survey> {
    const response = await apiClient.post<Survey>('/surveys', survey)
    return response.data
  },

  async update(id: string, survey: SurveyDto): Promise<Survey> {
    const response = await apiClient.put<Survey>(`/surveys/${id}`, survey)
    return response.data
  },

  async delete(id: string): Promise<void> {
    await apiClient.delete(`/surveys/${id}`)
  },
  async getSurveyResults(surveyId: string): Promise<SurveyResultDto[]> {
    const response = await apiClient.get<SurveyResultDto[]>(`/surveys/${surveyId}/results`)
    return response.data
  },
  async getNumberOfParticipants(surveyId: string): Promise<number> {
    const response = await apiClient.get<number>(`/surveys/${surveyId}/participants`)
    return response.data
  }
}
