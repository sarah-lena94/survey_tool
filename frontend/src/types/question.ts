export interface Question {
  id: string
  surveyId: string
  text: string
  position: number
}

export interface QuestionDto {
  surveyId: string
  text: string
  position: number
}
