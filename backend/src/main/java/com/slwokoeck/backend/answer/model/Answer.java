package com.slwokoeck.backend.answer.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.slwokoeck.backend.response.model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name = "response_id")
    Response response;
    Long questionId;
    Integer rating;
    String textAnswer;
}
