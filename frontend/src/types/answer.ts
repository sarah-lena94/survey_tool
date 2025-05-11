export interface Answer {
  id: number
  responseId: string
  questionId: number
  rating?: number
  textAnswer?: string
}

export interface AnswerDto {
  responseId: string
  questionId: number
  rating?: number
  textAnswer?: string
}
