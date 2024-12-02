package ru.jaroslav_zakharov.wallets.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("Incorrectly made request.");
        return new ErrorResponse(HttpStatus.BAD_REQUEST," Incorrectly made request.", e.getMessage(),
                LocalDateTime.now());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse handleObjectNotFoundException(ObjectNotFoundException e) {
        log.warn("For the requested operation the conditions are not met.");
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Integrity constraint has been violated.", e.getMessage(),
                LocalDateTime.now());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    ErrorResponse handleRulesViolationException(RulesViolationException e) {
        return new ErrorResponse(HttpStatus.CONFLICT, "For the requested operation the conditions are not met.",
                e.getMessage(), LocalDateTime.now());

    }
}
