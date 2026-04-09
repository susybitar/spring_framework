package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.exceptions;

/**
 * Excepcion personalizada para la gestion de errores de negocio relacionados con Personas.
 * Permite lanzar mensajes especificos cuando un recurso no es encontrado o hay conflictos.
 */
public class PersonServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor que inicializa la excepcion con un mensaje detallado.
     *
     * @param message Texto descriptivo del error.
     */
    public PersonServiceException(String message) {
        super(message);
    }
}