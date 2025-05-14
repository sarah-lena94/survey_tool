package com.slwokoeck.backend.response.service.impl;

 import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.response.dto.ResponseDto;
import com.slwokoeck.backend.response.model.Response;
import com.slwokoeck.backend.response.repository.ResponseRepository;
import com.slwokoeck.backend.response.service.ResponseService;
import com.slwokoeck.backend.survey.service.SurveyService;

 @Service
 public class ResponseServiceImpl implements ResponseService {

     private final ResponseRepository responseRepository;

     private final SurveyService surveyService;

     @Autowired
     public ResponseServiceImpl(ResponseRepository responseRepository, SurveyService surveyService) {
         this.responseRepository = responseRepository;
         this.surveyService = surveyService;
     }
     
     @Override
     public Response getResponseById(UUID id) {
         return responseRepository.findById(id).orElse(null);
     }

     @Override
     public List<Response> getAllResponses() {
         return responseRepository.findAll();
     }

     @Override
     public Response createResponse(ResponseDto responseDto) {
         Response response = new Response();
         response.setId(UUID.randomUUID());
         response.setSurvey(surveyService.getSurveyById(responseDto.getSurveyId()));
         response.setSubmittedAt(responseDto.getSubmittedAt());
         return responseRepository.save(response);
     }

     @Override
     public Response updateResponse(UUID id, ResponseDto responseDto) {
         Response existingResponse = responseRepository.findById(id).orElse(null);
         if (existingResponse == null) {
             return null;
         }
         existingResponse.setSurvey(surveyService.getSurveyById(responseDto.getSurveyId()));
         existingResponse.setSubmittedAt(responseDto.getSubmittedAt());
         return responseRepository.save(existingResponse);
     }

     @Override
     public void deleteResponse(UUID id) {
         responseRepository.deleteById(id);
     }
 }