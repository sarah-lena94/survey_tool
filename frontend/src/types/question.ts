export interface Question {
  id: number
  surveyId: string
  text: string
  position: number
  scaleLabels?: string[]
}

export interface QuestionDto {
  surveyId: string
  text: string
  position: number
  scaleLabels?: string[]
}
