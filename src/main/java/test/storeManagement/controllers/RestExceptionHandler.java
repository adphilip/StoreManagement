package test.storeManagement.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @ExceptionHandler(value = { AccessDeniedException.class })
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse badRequest(AccessDeniedException ex)
    {
        log.error("Exception occured", ex);
        return new ErrorResponse(403, "Forbidden");
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(Exception ex)
    {
        log.error("Exception occured", ex);
        return new ErrorResponse(400, "BadRequest");
    }
}
