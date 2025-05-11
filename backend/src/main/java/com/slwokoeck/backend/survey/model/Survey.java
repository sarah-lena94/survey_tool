package com.slwokoeck.backend.survey.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.question.model.Question;

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
public class Survey {
    @Id
    UUID id;
    String title;
    LocalDateTime createdAt;
    boolean isTemplate;
    @OneToMany(mappedBy = "survey")
    List<Question> questions;
}
