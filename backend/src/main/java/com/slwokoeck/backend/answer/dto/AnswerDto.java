package com.slwokoeck.backend.answer.dto;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

    Long id;

    @NotNull(message = "Response ID cannot be null")
    UUID responseId;

    Long questionId;

    @Min(1) 
    @Max(6)
    Integer rating;

    @Size(max = 1000, message = "Answer cannot exceed 1000 characters")
    String textAnswer;
}