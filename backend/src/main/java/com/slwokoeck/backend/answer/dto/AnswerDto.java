package com.slwokoeck.backend.answer.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    Long id;
    UUID responseId;
    Long questionId;
    Integer rating;
    String textAnswer;
}