package com.slwokoeck.backend.answer.service;

import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.answer.dto.AnswerDto;
import com.slwokoeck.backend.answer.model.Answer;

public interface AnswerService {
    Answer getAnswerById(UUID id);
    List<Answer> getAllAnswers();
    Answer createAnswer(AnswerDto answerDto);
    Answer updateAnswer(UUID id, AnswerDto answerDto);
    void deleteAnswer(UUID id);
}