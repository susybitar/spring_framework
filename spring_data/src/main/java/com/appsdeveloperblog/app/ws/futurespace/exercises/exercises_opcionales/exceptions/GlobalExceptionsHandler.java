package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.exceptions;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Clase controladora de excepciones a nivel global.
 * Intercepta los errores lanzados por cualquier controlador y los formatea
 * adecuadamente antes de enviarlos al cliente.
 */
@ControllerAdvice
public class GlobalExceptionsHandler {

    /**
     * Gestiona las excepciones de logica de negocio (PersonServiceException).
     *
     * @param ex      La excepcion capturada.
     * @param request La peticion web donde ocurrio el fallo.
     * @return Respuesta con estado 404 Not Found.
     */
    @ExceptionHandler(value = {PersonServiceException.class})
    public ResponseEntity<Object> handlePersonServiceException(PersonServiceException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    /**
     * Gestiona los errores de validacion de campos (anotaciones @NotBlank, @Size, etc.).
     * Extrae el mensaje definido en la entidad para mostrarlo al usuario.
     *
     * @param ex Excepcion de validacion de argumentos.
     * @return Respuesta con estado 400 Bad Request y el motivo del fallo.
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Obtenemos el mensaje de error que configuramos en la clase Person
        String defaultMessage = "Error de validacion";
        if (ex.getBindingResult().getFieldError() != null) {
            defaultMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        }

        ErrorMessage description = new ErrorMessage(new Date(), defaultMessage);
        return new ResponseEntity<>(description, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Captura cualquier otra excepcion no controlada para evitar que la API se detenga.
     *
     * @param ex      Excepcion generica.
     * @param request La peticion web.
     * @return Respuesta con estado 500 Internal Server Error.
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), "Ocurrio un error inesperado: " + ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}