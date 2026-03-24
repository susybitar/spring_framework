package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.exceptions;

/**
 * Excepcion personalizada para la gestion de personas.
 * Hereda de RuntimeException para que Spring pueda capturarla
 * automaticamente y gestionar el rollback si fuera necesario.
 */
public class PersonServiceException extends RuntimeException {

    /** Identificador de version para la serializacion. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor que recibe un mensaje descriptivo del error.
     * @param message Texto que explica el fallo (ej. Persona no encontrada).
     */
    public PersonServiceException(String message) {
        super(message);
    }
}