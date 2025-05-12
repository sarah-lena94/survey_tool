package com.slwokoeck.backend.question.service;

import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.question.model.Question;

public interface QuestionService {
    Question getQuestionById(UUID id);
    List<Question> getAllQuestions();
    Question createQuestion(Question question);
    Question updateQuestion(UUID id, Question question);
    void deleteQuestion(UUID id);
}