package com.slwokoeck.backend.question.model;

import java.util.UUID;

import com.slwokoeck.backend.survey.model.Survey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    UUID id;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    Survey survey;

    String text;

    Integer position;
}
