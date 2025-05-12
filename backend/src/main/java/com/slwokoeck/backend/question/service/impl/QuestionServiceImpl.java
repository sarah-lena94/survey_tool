package com.slwokoeck.backend.question.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.question.model.Question;
import com.slwokoeck.backend.question.repository.QuestionRepository;
import com.slwokoeck.backend.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question getQuestionById(UUID id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(UUID id, Question question) {
        question.setId(id);
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(UUID id) {
        questionRepository.deleteById(id);
    }
}