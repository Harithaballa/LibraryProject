package com.redshift.LibrarApplicationn.Exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler 
{
	
	private static Logger logger=Logger.getLogger( ControllerAdvisor.class);

	@ExceptionHandler(EmptyFieldException.class)
	//@ResponseStatus(value = )

    public ResponseEntity<Object> handleInvalidAddressIdExceptio(
    		EmptyFieldException ex, HttpServletRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Address field is empty ");
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

	 //logger.info("entered to handler");
    @ExceptionHandler(InvalidIdException.class)  
    public ResponseEntity<Object> handleInvalidAddressException(InvalidIdException ex, HttpServletRequest request) 
    {
      
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Invalid address id");
        logger.info("advisor");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

   
}
