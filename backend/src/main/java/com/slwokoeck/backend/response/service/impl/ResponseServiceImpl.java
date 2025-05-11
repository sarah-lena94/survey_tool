package com.slwokoeck.backend.response.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slwokoeck.backend.response.model.Response;
import com.slwokoeck.backend.response.repository.ResponseRepository;
import com.slwokoeck.backend.response.service.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public Response getResponseById(UUID id) {
        return responseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }

    @Override
    public Response createResponse(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public Response updateResponse(UUID id, Response response) {
        response.setId(id);
        return responseRepository.save(response);
    }

    @Override
    public void deleteResponse(UUID id) {
        responseRepository.deleteById(id);
    }
}