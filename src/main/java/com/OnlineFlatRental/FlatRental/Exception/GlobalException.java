package com.OnlineFlatRental.FlatRental.Exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.OnlineFlatRental.FlatRental.Utility.ErrorInfo;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalException {
	
	@Autowired
	Environment environment;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());

		String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(", "));
		errorInfo.setErrorMessage(errorMsg);
		errorInfo.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInfo> pathExceptionHandler(ConstraintViolationException exception) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		String errorMsg = exception.getConstraintViolations().stream().map(x -> x.getMessage())
				.collect(Collectors.joining(", "));
		errorInfo.setErrorMessage(errorMsg);
		errorInfo.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = FlatBookingNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleFlatBookingNotFoundException(FlatBookingNotFoundException fbnf)
	{
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(fbnf.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = FlatNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleFlatNotFoundException(FlatNotFoundException fnf){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(fnf.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = LandlordNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleLandlordNotFoundException(LandlordNotFoundException lnf){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(lnf.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);	
	}

	@ExceptionHandler(value = TenantNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleTenantNotFoundException(TenantNotFoundException tnf){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(tnf.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUserNotFoundException(UserNotFoundException unf)
	{   ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(unf.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<ErrorInfo> handleValidationException(ValidationException ve) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(ve.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
}
