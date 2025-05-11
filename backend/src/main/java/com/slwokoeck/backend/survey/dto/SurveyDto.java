package com.slwokoeck.backend.survey.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.question.dto.QuestionDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDto {
    UUID id;
    @NotBlank(message = "Title cannot be blank")
    String title;
    LocalDateTime createdAt;
    boolean isTemplate;
    List<QuestionDto> questions;
}