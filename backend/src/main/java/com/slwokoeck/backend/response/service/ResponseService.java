package com.slwokoeck.backend.response.service;

import java.util.List;
import java.util.UUID;

import com.slwokoeck.backend.response.dto.ResponseDto;
import com.slwokoeck.backend.response.model.Response;

public interface ResponseService {
    Response getResponseById(UUID id);
    List<Response> getAllResponses();
    Response createResponse(ResponseDto responseDto);
    Response updateResponse(UUID id, ResponseDto responseDto);
    void deleteResponse(UUID id);
}