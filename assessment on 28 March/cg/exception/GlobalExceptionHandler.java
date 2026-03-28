package assesment2.cg.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLoanAmountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAmount(InvalidLoanAmountException ex) {
        ErrorResponse error = new ErrorResponse(
            "InvalidLoanAmountException", 
            ex.getMessage(), 
            HttpStatus.BAD_REQUEST.value(), // 400
            LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateLoanApplicationException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateLoanApplicationException ex) {
        ErrorResponse error = new ErrorResponse(
            "DuplicateLoanApplicationException", 
            ex.getMessage(), 
            HttpStatus.CONFLICT.value(), // 409
            LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(LoanNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
            "LoanNotFoundException", 
            ex.getMessage(), 
            HttpStatus.NOT_FOUND.value(), // 404
            LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        ErrorResponse error = new ErrorResponse(
            "InternalServerError", 
            "An unexpected error occurred", 
            HttpStatus.INTERNAL_SERVER_ERROR.value(), // 500
            LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}