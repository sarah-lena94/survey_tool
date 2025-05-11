package com.slwokoeck.backend.answer.model;

import com.slwokoeck.backend.response.model.Response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
