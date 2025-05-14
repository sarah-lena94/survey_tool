package com.slwokoeck.backend.response.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slwokoeck.backend.response.model.Response;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResponseRepository extends JpaRepository<Response, UUID> {

    @Query("SELECT COUNT(r) FROM Response r WHERE r.survey.id = :surveyId")
    Long countBySurveyId(@Param("surveyId") UUID surveyId);

}