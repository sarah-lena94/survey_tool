package com.slwokoeck.backend.answer.service;

import java.util.List;

import com.slwokoeck.backend.answer.model.Answer;

public interface AnswerService {
    Answer getAnswerById(Long id);
    List<Answer> getAllAnswers();
    Answer createAnswer(Answer answer);
    Answer updateAnswer(Long id, Answer answer);
    void deleteAnswer(Long id);
}