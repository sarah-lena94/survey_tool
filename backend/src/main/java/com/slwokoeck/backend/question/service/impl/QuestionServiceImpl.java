package com.slwokoeck.backend.question.service.impl;

import java.util.List;

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
    public Question getQuestionById(Long id) {
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
    public Question updateQuestion(Long id, Question question) {
        question.setId(id);
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}