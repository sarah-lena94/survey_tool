package com.slwokoeck.backend.survey.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.survey.model.Survey;
import com.slwokoeck.backend.survey.repository.SurveyRepository;
import com.slwokoeck.backend.survey.service.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService {

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
}