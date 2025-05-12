package com.slwokoeck.backend.response.model;

import java.time.LocalDateTime;
import com.slwokoeck.backend.survey.model.Survey;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.answer.model.Answer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @Id
    UUID id;

    @ManyToOne
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    Survey survey;

    LocalDateTime submittedAt;
    
    @OneToMany(mappedBy = "response")
    List<Answer> answers;
}
