package com.slwokoeck.backend.answer.service.impl;

import java.util.UUID;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.answer.dto.AnswerDto;
import com.slwokoeck.backend.answer.model.Answer;
import com.slwokoeck.backend.answer.repository.AnswerRepository;
import com.slwokoeck.backend.answer.service.AnswerService;
import com.slwokoeck.backend.question.model.Question;
import com.slwokoeck.backend.question.service.QuestionService;
import com.slwokoeck.backend.response.model.Response;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, @Lazy QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
    }

    @Override
    public Answer getAnswerById(UUID id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer createAnswer(AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setId(UUID.randomUUID());
        Response response = new Response();
        response.setId(answerDto.getResponseId());
        answer.setResponse(response);
        Question question = questionService.getQuestionById(answerDto.getQuestionId());
        answer.setQuestion(question);
        answer.setRating(answerDto.getRating());
        answer.setTextAnswer(answerDto.getTextAnswer());
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(UUID id, AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setId(id);
        Response response = new Response();
        response.setId(answerDto.getResponseId());
        answer.setResponse(response);
        Question question = questionService.getQuestionById(answerDto.getQuestionId());
        answer.setQuestion(question);
        answer.setRating(answerDto.getRating());
        answer.setTextAnswer(answerDto.getTextAnswer());
        return answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(UUID id) {
        answerRepository.deleteById(id);
    }
}