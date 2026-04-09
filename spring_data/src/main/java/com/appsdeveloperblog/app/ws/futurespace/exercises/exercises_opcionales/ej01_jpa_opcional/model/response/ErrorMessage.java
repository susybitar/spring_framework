package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.ej01_jpa_opcional.model.response;

import java.util.Date;

/**
 * Clase que define la estructura estandar de los mensajes de error devueltos por la API.
 * Asegura que el cliente reciba informacion util como la fecha y el motivo del fallo.
 */
public class ErrorMessage {

    private Date timestamp;
    private String message;

    /**
     * Constructor para crear una respuesta de error completa.
     *
     * @param timestamp Momento exacto en el que ocurrio el error.
     * @param message   Descripcion amigable del problema.
     */
    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    // Getters para permitir que Jackson convierta el objeto a JSON/XML
    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}