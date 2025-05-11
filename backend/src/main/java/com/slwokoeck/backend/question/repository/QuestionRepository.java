package com.slwokoeck.backend.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slwokoeck.backend.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}