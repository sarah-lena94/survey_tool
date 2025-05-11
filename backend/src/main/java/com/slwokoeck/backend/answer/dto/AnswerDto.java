package com.slwokoeck.backend.answer.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
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
    Integer rating;
    String textAnswer;
}