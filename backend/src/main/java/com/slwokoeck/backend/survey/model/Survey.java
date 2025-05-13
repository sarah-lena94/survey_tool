package com.slwokoeck.backend.survey.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.slwokoeck.backend.question.model.Question;

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
public class Survey {
    @Id
    UUID id;

    String title;

    LocalDateTime createdAt;

    Boolean isTemplate;
    
    @OneToMany(mappedBy = "survey")
    @JsonManagedReference
    List<Question> questions;
}
