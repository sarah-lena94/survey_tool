package com.slwokoeck.backend.question.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    Long id;
    UUID surveyId;
    @NotBlank(message = "Text cannot be blank")
    String text;
    Integer position;
    // QuestionType type;
    List<String> scaleLabels;
}