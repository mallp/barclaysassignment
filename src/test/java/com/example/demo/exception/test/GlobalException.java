package com.example.demo.exception.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.exception.GlobalExceptionHandling;
import com.example.demo.exception.LowerVersionFoundException;
import com.example.demo.exception.NotFoundException;

@RunWith(SpringRunner.class)
public class GlobalException {
	
	@InjectMocks
	GlobalExceptionHandling globalExceptionHandling;
	
	@Test
	public void handleExceptionsTest() {
		LowerVersionFoundException exception = new LowerVersionFoundException();
		NotFoundException exception1 = new NotFoundException();
		globalExceptionHandling.handleExceptions(exception);
		globalExceptionHandling.handleExceptions(exception1);
	}

}
