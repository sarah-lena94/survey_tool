package com.slwokoeck.backend.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slwokoeck.backend.answer.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}