package com.slwokoeck.backend.survey.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slwokoeck.backend.survey.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, UUID> {

}