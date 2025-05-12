package com.slwokoeck.backend.answer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.slwokoeck.backend.answer.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {

    @Query("SELECT AVG(a.rating) FROM Answer a WHERE a.question.id = :questionId")
    Double findAverageAnswerByQuestionId(UUID questionId);
}