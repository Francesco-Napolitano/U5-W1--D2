package it.esMattino.manutenzioni.exception;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<String> entityNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>("Error da classe: "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<Error> alreadyExists(EntityExistsException ex) {
        Error error = new Error();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
