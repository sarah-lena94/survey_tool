import apiClient from '../client'
import type { Question, QuestionDto } from '@/types/question'

export const questionService = {
  async getAll(): Promise<Question[]> {
    const response = await apiClient.get<Question[]>('/questions')
    return response.data
  },

  async getById(id: string): Promise<Question> {
    const response = await apiClient.get<Question>(`/questions/${id}`)
    return response.data
  },

  async create(question: QuestionDto): Promise<Question> {
    const response = await apiClient.post<Question>('/questions', question)
    return response.data
  },

  async update(id: string, question: QuestionDto): Promise<Question> {
    const response = await apiClient.put<Question>(`/questions/${id}`, question)
    return response.data
  },

  async delete(id: string): Promise<void> {
    await apiClient.delete(`/questions/${id}`)
  }
}
