package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.ej01_jpa_opcional.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Controlador raíz del proyecto de Ejercicios Opcionales Spring Data JPA.
 * Proporciona un índice de todos los endpoints disponibles en la API para facilitar la navegación.
 */
@RestController
public class RootController {

    /**
     * Endpoint raíz que sirve como guía de la API.
     *
     * @return Map con la descripción de los ejercicios y sus rutas.
     */
    @GetMapping("/")
    public Map<String, String> getApiIndex() {
        Map<String, String> index = new LinkedHashMap<>();

        index.put("Proyecto", "Ejercicios Spring Data JPA - Futurespace");
        index.put("Ejercicio 01 - GET (Lista de Personas)", "/persons");
        index.put("Ejercicio 02 - POST (Alta de Persona)", "/persons");
        index.put("Ejercicio 03 - PUT (Actualización por DNI)", "/persons/{dni}");

        return index;
    }
}