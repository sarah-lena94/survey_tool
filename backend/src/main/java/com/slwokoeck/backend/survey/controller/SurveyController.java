package com.slwokoeck.backend.survey.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slwokoeck.backend.survey.dto.SurveyDto;
import com.slwokoeck.backend.survey.model.Survey;
import com.slwokoeck.backend.survey.service.SurveyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable UUID id) {
        Survey survey = surveyService.getSurveyById(id);
        if (survey != null) {
            return new ResponseEntity<>(survey, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Survey> createSurvey(@Valid @RequestBody SurveyDto surveyDto) {
        Survey survey = new Survey();
        survey.setTitle(surveyDto.getTitle());
        survey.setCreatedAt(surveyDto.getCreatedAt());
        survey.setTemplate(surveyDto.isTemplate());
        Survey createdSurvey = surveyService.createSurvey(survey);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable UUID id, @Valid @RequestBody SurveyDto surveyDto) {
        Survey survey = new Survey();
        survey.setTitle(surveyDto.getTitle());
        survey.setCreatedAt(surveyDto.getCreatedAt());
        survey.setTemplate(surveyDto.isTemplate());
        Survey updatedSurvey = surveyService.updateSurvey(id, survey);
        if (updatedSurvey != null) {
            return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable UUID id) {
        surveyService.deleteSurvey(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}