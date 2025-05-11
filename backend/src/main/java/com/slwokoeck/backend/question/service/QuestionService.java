package com.slwokoeck.backend.question.service;

import java.util.List;

import com.slwokoeck.backend.question.model.Question;

public interface QuestionService {
    Question getQuestionById(Long id);
    List<Question> getAllQuestions();
    Question createQuestion(Question question);
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
}