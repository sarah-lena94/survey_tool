package com.slwokoeck.backend.survey.service.impl;

import com.slwokoeck.backend.answer.repository.AnswerRepository;
import com.slwokoeck.backend.question.model.Question;
import com.slwokoeck.backend.survey.dto.SurveyResultDto;
import com.slwokoeck.backend.survey.model.Survey;
import com.slwokoeck.backend.survey.repository.SurveyRepository;
import com.slwokoeck.backend.survey.service.SurveyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SurveyResultServiceImpl implements SurveyResultService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<SurveyResultDto> calculateSurveyResults(UUID surveyId) {
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        if (survey == null) {
            return List.of();
        }

        List<SurveyResultDto> results = new ArrayList<>();
        for (Question question : survey.getQuestions()) {
            Double averageAnswer = answerRepository.findAverageAnswerByQuestionId(question.getId());
            if (averageAnswer != null) {
                results.add(new SurveyResultDto(question.getText(), averageAnswer));
            }
        }

        return results;
    }
}