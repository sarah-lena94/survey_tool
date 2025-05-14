package com.slwokoeck.backend.response.controller;

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

import com.slwokoeck.backend.response.dto.ResponseDto;
import com.slwokoeck.backend.response.model.Response;
import com.slwokoeck.backend.response.service.ResponseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    private final ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getResponseById(@PathVariable UUID id) {
        Response response = responseService.getResponseById(id);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Response>> getAllResponses() {
        List<Response> responses = responseService.getAllResponses();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> createResponse(@Valid @RequestBody ResponseDto responseDto) {
        try {
            Response createdResponse = responseService.createResponse(responseDto);
            return new ResponseEntity<>(createdResponse, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateResponse(@PathVariable UUID id, @Valid @RequestBody ResponseDto responseDto) {
        try {
            Response updatedResponse = responseService.updateResponse(id, responseDto);
            if (updatedResponse != null) {
                return new ResponseEntity<>(updatedResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable UUID id) {
        responseService.deleteResponse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}