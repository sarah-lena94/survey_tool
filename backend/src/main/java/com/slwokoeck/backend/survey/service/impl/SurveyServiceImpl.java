package com.slwokoeck.backend.survey.service.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.question.dto.QuestionDto;
import com.slwokoeck.backend.question.service.QuestionService;
import com.slwokoeck.backend.response.repository.ResponseRepository;
import com.slwokoeck.backend.survey.dto.SurveyDto;
import com.slwokoeck.backend.survey.model.Survey;
import com.slwokoeck.backend.survey.repository.SurveyRepository;
import com.slwokoeck.backend.survey.service.SurveyService;

@Service
@Slf4j
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    private final ResponseRepository responseRepository;

    private final QuestionService questionService;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository, ResponseRepository responseRepository, @Lazy QuestionService questionService) {
        this.surveyRepository = surveyRepository;
        this.responseRepository = responseRepository;
        this.questionService = questionService;
    }

    @Override
    public Survey getSurveyById(UUID id) {
        return surveyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey createSurvey(SurveyDto surveyDto) {
        Survey survey = new Survey();
        survey.setId(UUID.randomUUID());
        survey.setTitle(surveyDto.getTitle());
        survey.setCreatedAt(surveyDto.getCreatedAt());
        survey.setIsTemplate(surveyDto.isTemplate());
        Survey createdSurvey = surveyRepository.save(survey);
        log.info("Survey ID after saving: {}", createdSurvey.getId());

        // Create questions for the survey
        if (surveyDto.getQuestions() != null) {
            for (QuestionDto questionDto : surveyDto.getQuestions()) {
                questionDto.setSurveyId(createdSurvey.getId());
                questionService.createQuestion(questionDto);
            }
        }
        return createdSurvey;
    }

    @Override
    public Survey updateSurvey(UUID id, SurveyDto surveyDto) {
        Survey survey = new Survey();
        survey.setId(id);
        survey.setTitle(surveyDto.getTitle());
        survey.setCreatedAt(surveyDto.getCreatedAt());
        survey.setIsTemplate(surveyDto.isTemplate());
        return surveyRepository.save(survey);
    }

    @Override
    public void deleteSurvey(UUID id) {
        surveyRepository.deleteById(id);
    }

    @Override
    public Long getNumberOfParticipants(UUID surveyId) {
        return responseRepository.countBySurveyId(surveyId);
    }
}