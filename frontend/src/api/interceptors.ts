import type { AxiosInstance, AxiosError, AxiosResponse } from 'axios'

export function setupInterceptors(apiClient: AxiosInstance): void {
  apiClient.interceptors.request.use(
    (config) => {
      // Logging oder andere Vorverarbeitung
      return config
    },
    (error) => {
      console.error('Request error:', error)
      return Promise.reject(error)
    }
  )

  apiClient.interceptors.response.use(
    (response: AxiosResponse) => {
      return response
    },
    (error: AxiosError) => {
      if (error.response) {
        console.error(`API Error: ${error.response.status}`, error.response.data)
      } else {
        console.error('API Error:', error.message)
      }
      return Promise.reject(error)
    }
  )
}
