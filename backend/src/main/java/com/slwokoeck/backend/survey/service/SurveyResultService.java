package com.slwokoeck.backend.survey.service;

import com.slwokoeck.backend.survey.dto.SurveyResultDto;
import java.util.List;
import java.util.UUID;

public interface SurveyResultService {
    List<SurveyResultDto> calculateSurveyResults(UUID surveyId);
}