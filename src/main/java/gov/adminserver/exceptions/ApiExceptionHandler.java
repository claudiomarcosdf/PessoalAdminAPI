package gov.adminserver.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	
    @ExceptionHandler(PolicialNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleGenericNotFoundException(PolicialNotFoundException ex, ServerHttpRequest serverHttpRequest) {
    	ErrorMessage error = new ErrorMessage(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value(), serverHttpRequest.getURI().toString()); 
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = {MatriculaExistenteException.class})
    public ResponseEntity<Object> handleException(MatriculaExistenteException ex, ServerHttpRequest serverHttpRequest) {
        return new ResponseEntity<Object>(new ErrorMessage(new Date(), ex.getMessage(), HttpStatus.NOT_ACCEPTABLE.value(), serverHttpRequest.getURI().toString()), 
        		new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }    

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex, ServerHttpRequest serverHttpRequest) {
        return new ResponseEntity<Object>(new ErrorMessage(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), serverHttpRequest.getURI().toString()), 
        		new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }	

}
