package com.slwokoeck.backend.question.model;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.slwokoeck.backend.survey.model.Survey;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    Survey survey;
    String text;
    Integer position;
    // QuestionType type;
    List<String> scaleLabels;
}
