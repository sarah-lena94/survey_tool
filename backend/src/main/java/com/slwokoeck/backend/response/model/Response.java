package com.slwokoeck.backend.response.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.answer.model.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @Id
    UUID id;
    UUID surveyId;
    LocalDateTime submittedAt;
    @OneToMany(mappedBy = "response")
    List<Answer> answers;
}
