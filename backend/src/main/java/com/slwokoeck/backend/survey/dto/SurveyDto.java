package com.slwokoeck.backend.survey.dto;

import org.springframework.lang.Nullable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.question.dto.QuestionDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDto {

    @Nullable
    UUID id;

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 255, message = "Title cannot exceed 255 characters")
    String title;
    
    LocalDateTime createdAt;
    
    boolean isTemplate;
    
    List<QuestionDto> questions;

}