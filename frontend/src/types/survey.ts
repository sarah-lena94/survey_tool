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
  description: string;
  createdAt: string;
  isTemplate: boolean;
}

export type { Question };
