package com.slwokoeck.backend.question.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    Long id;
    UUID surveyId;
    String text;
    Integer position;
    // QuestionType type;
    List<String> scaleLabels;
}