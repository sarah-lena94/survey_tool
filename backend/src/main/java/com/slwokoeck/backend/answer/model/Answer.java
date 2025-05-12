package com.slwokoeck.backend.answer.model;

import java.util.UUID;
import com.slwokoeck.backend.question.model.Question;

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
    UUID id;

    @ManyToOne
    @JoinColumn(name = "response_id")
    Response response;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    Question question;
    
    Integer rating;

    String textAnswer;
}
