import axios from 'axios'
import { setupInterceptors } from './interceptors.js'

const apiClient = axios.create({
  baseURL: '/api',
  headers: {
    'Content-Type': 'application/json',
  },
})

setupInterceptors(apiClient)

export default apiClient
