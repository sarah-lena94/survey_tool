package com.slwokoeck.backend.survey.service.impl;

import java.util.UUID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.survey.model.Survey;
import com.slwokoeck.backend.survey.repository.SurveyRepository;
import com.slwokoeck.backend.response.repository.ResponseRepository;
import com.slwokoeck.backend.survey.service.SurveyService;
@Service
public class SurveyServiceImpl implements SurveyService {

    private final ResponseRepository responseRepository;

    public SurveyServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }


    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Survey getSurveyById(UUID id) {
        return surveyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey updateSurvey(UUID id, Survey survey) {
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