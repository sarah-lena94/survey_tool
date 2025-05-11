package com.slwokoeck.backend.response.service;

import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.response.model.Response;

public interface ResponseService {
    Response getResponseById(UUID id);
    List<Response> getAllResponses();
    Response createResponse(Response response);
    Response updateResponse(UUID id, Response response);
    void deleteResponse(UUID id);
}