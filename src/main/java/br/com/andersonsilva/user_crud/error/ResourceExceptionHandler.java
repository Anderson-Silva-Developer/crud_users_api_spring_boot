package br.com.andersonsilva.user_crud.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<br.com.andersonsilva.error.StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        br.com.andersonsilva.error.StandardError err=new br.com.andersonsilva.error.StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not Found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<br.com.andersonsilva.error.StandardError> entityBadRequest(HttpMessageNotReadableException e, HttpServletRequest request) {
        br.com.andersonsilva.error.StandardError err=new br.com.andersonsilva.error.StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Bad Request");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<br.com.andersonsilva.error.StandardError> NoSuchElement(NoSuchElementException e, HttpServletRequest request) {
        br.com.andersonsilva.error.StandardError err=new br.com.andersonsilva.error.StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        err.setError("Internal Server Error");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);

    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<br.com.andersonsilva.error.StandardError> RequestMethodNotSupport(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        br.com.andersonsilva.error.StandardError err=new br.com.andersonsilva.error.StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
        err.setError("METHOD_NOT_ALLOWED");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(err);

    }


}
