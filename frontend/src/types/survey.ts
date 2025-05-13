import type { Question } from './question.ts';

export interface Survey {
  id: string;
  title: string;
  createdAt: string;
  isTemplate: boolean;
  questions?: Question[];
}

export interface SurveyDto {
  title: string;
  createdAt: string;
  isTemplate: boolean;
  questions?: Question[]; // Add the questions property
}

export interface SurveyResultDto {
  questionText: string;
  averageAnswer: number;
}

export type { Question };
