package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
	

	@ExceptionHandler(LowerVersionFoundException.class)
    public ResponseEntity<Object> handleExceptions( LowerVersionFoundException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Lower Version found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return entity;
    }

	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleExceptions(NotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Data base is empty.please run below query to add data in h2 database by using url: http://localhost:8081/h2-ui/ . insert into trades (TRADE_ID,BOOK_ID,COUNTER_PARTY_ID,CREATED_DATE,EXPIRED,MATURITY_DATE,VERSION) values ('T1','B1','CP-1','2014-04-14','N','2023-05-20',1), ('T2','B1','CP-2','2014-04-14','N','2023-05-21',2), ('T2','B1','CP-1','2015-03-14','N','2016-05-21',1), ('T3','B2','CP-3','2020-04-14','N','2014-05-20',3);");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return entity;
    }

}
