package com.intuit.playermicroservice.exception;

import java.time.ZonedDateTime;

import com.intuit.playermicroservice.domain.dtos.PlayerErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> playerNotFoundExceptionHandler(PlayerNotFoundException ex, HttpServletRequest req){

        PlayerErrorResponse error = new PlayerErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                req.getRequestURI(),
                ex.getMessage());

        return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
    }
}