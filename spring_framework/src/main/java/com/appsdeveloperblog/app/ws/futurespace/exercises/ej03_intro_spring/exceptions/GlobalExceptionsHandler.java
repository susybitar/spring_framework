package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.exceptions;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Clase manejadora global para interceptar las excepciones lanzadas por la aplicacion
 * y devolver respuestas de error controladas en formato JSON.
 */
@ControllerAdvice
public class GlobalExceptionsHandler {

    /**
     * Captura nuestra excepcion personalizada (DNI no encontrado).
     * @param ex La excepcion de tipo PersonServiceException lanzada.
     * @param request Informacion de la peticion web actual.
     * @return ResponseEntity con el mensaje de error y estado HTTP 404.
     */
    @ExceptionHandler(value = {PersonServiceException.class})
    public ResponseEntity<Object> handlePersonServiceException(PersonServiceException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    /**
     * Captura los errores de validacion (Fecha, Nombre corto, etc.)
     * y extrae el mensaje de las anotaciones como Pattern o Size.
     * @param ex La excepcion de validacion lanzada por Spring.
     * @param request Informacion de la peticion web actual.
     * @return ResponseEntity con el mensaje de validacion y estado HTTP 400.
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorMessage description = new ErrorMessage(new Date(), errorMessage);
        return new ResponseEntity<>(description, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Captura cualquier otro error generico del sistema.
     * @param ex La excepcion generica lanzada.
     * @param request Informacion de la peticion web actual.
     * @return ResponseEntity con el mensaje de error y estado HTTP 500.
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}