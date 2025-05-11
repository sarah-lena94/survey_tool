import apiClient from '../client';
import type { Response, ResponseDto } from '@/types/response';
import type { AxiosResponse } from 'axios';

export const responseService = {
  async getAll(): Promise<Response[]> {
    const response: AxiosResponse<Response[]> = await apiClient.get('/responses');
    return response.data;
  },

  async getById(id: string): Promise<Response> {
    const response: AxiosResponse<Response> = await apiClient.get(`/responses/${id}`);
    return response.data;
  },

  async create(responseDto: ResponseDto): Promise<Response> {
    const response: AxiosResponse<Response> = await apiClient.post('/responses', responseDto);
    return response.data;
  },

  async update(id: string, responseDto: ResponseDto): Promise<Response> {
    const response: AxiosResponse<Response> = await apiClient.put(`/responses/${id}`, responseDto);
    return response.data;
  },

  async delete(id: string): Promise<void> {
    await apiClient.delete(`/responses/${id}`);
  }
};
