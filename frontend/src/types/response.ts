import type { Answer } from './answer';

export interface Response {
  id: string
  surveyId: string
  submittedAt: string
  answers?: Answer[]
}

export interface ResponseDto {
  surveyId: string
  submittedAt: string
}
