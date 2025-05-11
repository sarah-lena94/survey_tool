import apiClient from '../client.js'
import type { Answer, AnswerDto } from 'src/types/answer.ts';
import type { AxiosResponse } from 'axios';

export const answerService = {
  async getAll(): Promise<Answer[]> {
    const response: AxiosResponse<Answer[]> = await apiClient.get('/answers');
    return response.data;
  },

  async getById(id: string): Promise<Answer> {
    const response: AxiosResponse<Answer> = await apiClient.get(`/answers/${id}`);
    return response.data;
  },

  async create(answerDto: AnswerDto): Promise<Answer> {
    const response: AxiosResponse<Answer> = await apiClient.post('/answers', answerDto);
    return response.data;
  },

  async update(id: string, answerDto: Answer): Promise<Answer> {
    const response: AxiosResponse<Answer> = await apiClient.put(`/answers/${id}`, answerDto);
    return response.data;
  },

  async delete(id: string): Promise<void> {
    await apiClient.delete(`/answers/${id}`);
  }
};
