package com.slwokoeck.backend.question.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.question.dto.QuestionDto;
import com.slwokoeck.backend.question.model.Question;
import com.slwokoeck.backend.question.repository.QuestionRepository;
import com.slwokoeck.backend.question.service.QuestionService;
import com.slwokoeck.backend.survey.model.Survey;
import com.slwokoeck.backend.survey.repository.SurveyRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Question getQuestionById(UUID id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question createQuestion(QuestionDto questionDto) {
        Question question = new Question();
        question.setText(questionDto.getText());
        Survey survey = surveyRepository.findById(questionDto.getSurveyId())
                .orElseThrow(() -> new NoSuchElementException("Survey not found"));
        question.setSurvey(survey);
        question.setId(UUID.randomUUID());
        question.setPosition(questionDto.getPosition());
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(UUID id, QuestionDto questionDto) {
        Question existingQuestion = questionRepository.findById(id).orElse(null);
        if (existingQuestion == null) {
            return null;
        }
        existingQuestion.setText(questionDto.getText());
        Survey survey = surveyRepository.findById(questionDto.getSurveyId())
                .orElseThrow(() -> new NoSuchElementException("Survey not found"));
        existingQuestion.setSurvey(survey);
        existingQuestion.setPosition(questionDto.getPosition());
        return questionRepository.save(existingQuestion);
    }

    @Override
    public void deleteQuestion(UUID id) {
        questionRepository.deleteById(id);
    }
}