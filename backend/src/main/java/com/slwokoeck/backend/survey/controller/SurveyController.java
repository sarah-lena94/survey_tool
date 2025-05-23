package com.slwokoeck.backend.survey.controller;

import java.util.List;
import java.util.NoSuchElementException;
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
import org.springframework.web.server.ResponseStatusException;

import com.slwokoeck.backend.survey.dto.SurveyDto;
import com.slwokoeck.backend.survey.dto.SurveyResultDto;
import com.slwokoeck.backend.survey.model.Survey;
import com.slwokoeck.backend.survey.service.SurveyResultService;
import com.slwokoeck.backend.survey.service.SurveyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    private final SurveyResultService surveyResultService;

    @Autowired
    public SurveyController(SurveyService surveyService, SurveyResultService surveyResultService) {
        this.surveyService = surveyService;
        this.surveyResultService = surveyResultService;
    }

    @GetMapping("/{surveyId}/participants")
    public ResponseEntity<Long> getNumberOfParticipants(@PathVariable UUID surveyId) {
        Long numberOfParticipants = surveyService.getNumberOfParticipants(surveyId);
        return ResponseEntity.ok(numberOfParticipants);
    }

    @GetMapping("/{surveyId}/results")
    public ResponseEntity<List<SurveyResultDto>> getSurveyResults(@PathVariable UUID surveyId) {
        List<SurveyResultDto> results = surveyResultService.calculateSurveyResults(surveyId);
        if (results != null) {
            return new ResponseEntity<>(results, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable UUID id) {
        try {
            Survey survey = surveyService.getSurveyById(id);
            return new ResponseEntity<>(survey, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found", e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody SurveyDto surveyDto) {
        Survey createdSurvey = surveyService.createSurvey(surveyDto);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable UUID id, @Valid @RequestBody SurveyDto surveyDto) {
        try {
            Survey updatedSurvey = surveyService.updateSurvey(id, surveyDto);
            return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable UUID id) {
        surveyService.deleteSurvey(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}