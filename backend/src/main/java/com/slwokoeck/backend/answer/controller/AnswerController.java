package com.slwokoeck.backend.answer.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.slwokoeck.backend.answer.dto.AnswerDto;
import com.slwokoeck.backend.answer.model.Answer;
import com.slwokoeck.backend.answer.service.AnswerService;
import com.slwokoeck.backend.question.model.Question;
import com.slwokoeck.backend.question.service.QuestionService;
import com.slwokoeck.backend.response.model.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable UUID id) {
        Answer answer = answerService.getAnswerById(id);
        if (answer != null) {
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.getAllAnswers();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@Valid @RequestBody AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setId(UUID.randomUUID());
        Response response = new Response();
        response.setId(answerDto.getResponseId());
        answer.setResponse(response);
        Question question = questionService.getQuestionById(answerDto.getQuestionId());
        answer.setQuestion(question);
        answer.setRating(answerDto.getRating());
        answer.setTextAnswer(answerDto.getTextAnswer());
        try {
            Answer createdAnswer = answerService.createAnswer(answer);
            return new ResponseEntity<>(createdAnswer, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable UUID id, @Valid @RequestBody AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setId(UUID.randomUUID());
        Response response = new Response();
        response.setId(answerDto.getResponseId());
        answer.setResponse(response);
        Question question = questionService.getQuestionById(answerDto.getQuestionId());
        answer.setQuestion(question);
        answer.setRating(answerDto.getRating());
        answer.setTextAnswer(answerDto.getTextAnswer());
        try {
            Answer updatedAnswer = answerService.updateAnswer(id, answer);
            if (updatedAnswer != null) {
                return new ResponseEntity<>(updatedAnswer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable UUID id) {
        answerService.deleteAnswer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}