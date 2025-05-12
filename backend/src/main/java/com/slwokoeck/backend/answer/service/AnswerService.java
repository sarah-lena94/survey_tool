package com.slwokoeck.backend.answer.service;

import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.answer.model.Answer;

public interface AnswerService {
    Answer getAnswerById(UUID id);
    List<Answer> getAllAnswers();
    Answer createAnswer(Answer answer);
    Answer updateAnswer(UUID id, Answer answer);
    void deleteAnswer(UUID id);
}