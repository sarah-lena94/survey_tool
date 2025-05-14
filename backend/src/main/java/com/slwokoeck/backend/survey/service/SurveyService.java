package com.slwokoeck.backend.survey.service;

import java.util.UUID;

import java.util.List;

import com.slwokoeck.backend.survey.dto.SurveyDto;
import com.slwokoeck.backend.survey.model.Survey;

public interface SurveyService {
    Survey getSurveyById(UUID id);
    List<Survey> getAllSurveys();
    Survey createSurvey(SurveyDto surveyDto);
    Survey updateSurvey(UUID id, SurveyDto surveyDto);
    void deleteSurvey(UUID id);
    Long getNumberOfParticipants(UUID surveyId);
}