package com.shop.knowledgekart.controller;

import java.nio.file.AccessDeniedException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.shop.knowledgekart.dto.ErrorItem;
import com.shop.knowledgekart.dto.ErrorResponse;
import com.shop.knowledgekart.exception.ResourceNotFoundException;
/**
 * 
 * @author anaghabhide
 * 
 * Advice class handles all the exceptions 
 *
 */
@RestControllerAdvice
public class KnowledgeKartControllerAdvice {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e) {
        ErrorResponse errors = new ErrorResponse();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            ErrorItem error = new ErrorItem();
            error.setCode(violation.getMessageTemplate());
            error.setMessage(violation.getMessage());
            errors.addError(error);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorItem> handle(ResourceNotFoundException e) {
        ErrorItem error = new ErrorItem();
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = { AccessDeniedException.class })
    protected ResponseEntity<ErrorResponse> handleExceptionError(AccessDeniedException ex, WebRequest request) {
    	ErrorItem error = new ErrorItem();
        error.setMessage(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.addError(error);
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<ErrorResponse> handleExceptionError(Exception ex, WebRequest request) {
    	ErrorItem error = new ErrorItem();
        error.setMessage(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.addError(error);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}