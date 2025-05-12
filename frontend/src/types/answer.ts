export interface Answer {
  id: string
  responseId: string
  questionId: string
  rating?: number
  textAnswer?: string
}

export interface AnswerDto {
  responseId: string
  questionId: string
  rating?: number
  textAnswer?: string
}
