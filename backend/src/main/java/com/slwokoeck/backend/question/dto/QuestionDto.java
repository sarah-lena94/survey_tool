package com.slwokoeck.backend.question.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(max = 500, message = "Text cannot exceed 500 characters")
    String text;
    
    Integer position;
    
    // QuestionType type;
    
    List<String> scaleLabels;

}