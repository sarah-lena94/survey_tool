import type { Question } from './question.ts';

export interface Survey {
  id: string;
  title: string;
  description: string;
  createdAt: string;
  isTemplate: boolean;
  questions?: Question[];
}

export interface SurveyDto {
  title: string;
  description?: string; // Make description optional
  createdAt: string;
  isTemplate: boolean;
  questions?: Question[]; // Add the questions property
}

export interface SurveyResultDto {
  questionText: string;
  averageAnswer: number;
}

export type { Question };
