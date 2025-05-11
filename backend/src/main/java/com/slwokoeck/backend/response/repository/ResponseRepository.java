package com.slwokoeck.backend.response.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slwokoeck.backend.response.model.Response;

public interface ResponseRepository extends JpaRepository<Response, UUID> {

}