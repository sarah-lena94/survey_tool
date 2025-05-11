package com.slwokoeck.backend.response.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.answer.dto.AnswerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    UUID id;
    UUID surveyId;
    LocalDateTime submittedAt;
    List<AnswerDto> answers;
}