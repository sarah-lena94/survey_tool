import type { Question } from './question';

export interface Survey {
  id: string
  title: string
  createdAt: string
  isTemplate: boolean
  questions?: Question[]
}

export interface SurveyDto {
  title: string
  createdAt: string
  isTemplate: boolean
}
