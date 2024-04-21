package pl.akademiaspecjalistowit.jokeappspring.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

//    @ExceptionHandler({AccessDeniedException.class, BusinessException.class})
//    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request){
//        return new ResponseEntity<>("Access denied massage here", new HttpHeaders(), HttpStatus.FORBIDDEN);
//    }
}
