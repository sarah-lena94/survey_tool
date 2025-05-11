package com.slwokoeck.backend.answer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.answer.model.Answer;
import com.slwokoeck.backend.answer.repository.AnswerRepository;
import com.slwokoeck.backend.answer.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(Long id, Answer answer) {
        answer.setId(id);
        return answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}