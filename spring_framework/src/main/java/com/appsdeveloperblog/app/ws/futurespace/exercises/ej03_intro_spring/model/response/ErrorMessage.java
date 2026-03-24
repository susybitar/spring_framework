package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.response;

import java.util.Date;

/**
 * Clase de soporte para estandarizar las respuestas de error de la API.
 * Evita devolver trazas internas de Java al usuario.
 */
public class ErrorMessage {

    /** Marca de tiempo de cuando ocurrio el error. */
    private Date timestamp;

    /** Mensaje descriptivo del fallo. */
    private String message;

    /**
     * Constructor para inicializar el error con fecha y mensaje.
     * @param timestamp Momento en el que se produce la excepcion.
     * @param message Detalle del error.
     */
    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}