package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Controlador raíz del proyecto de Ejercicios Opcionales Spring Data JPA.
 * Proporciona un índice de todos los endpoints disponibles en la API para facilitar la navegación
 * y las pruebas desde el navegador o Postman.
 */
@RestController
public class RootController {

    /**
     * Endpoint raíz que sirve como guía de la API.
     * Muestra la relación entre los ejercicios realizados y sus rutas de acceso.
     *
     * @return Map con la descripción de los ejercicios y sus rutas correspondientes.
     */
    @GetMapping("/")
    public Map<String, String> getApiIndex() {
        Map<String, String> index = new LinkedHashMap<>();

        index.put("Proyecto", "Ejercicios Spring Data JPA - Futurespace");

        // Ejercicio 01: Listado general persistido en MySQL
        index.put("Ejercicio 01 - GET (Lista de Personas)", "/persons");

        // Ejercicio 02: Alta mediante envío de formulario (parámetros en URL)
        // Se añade esta ruta específica para diferenciar el comportamiento del formulario.
        index.put("Ejercicio 02 - POST (Envío Formulario URL)", "/persons/envioFormulario?dni=...&firstName=...");

        // Ejercicio 03: Actualización de datos buscando por el DNI como clave
        index.put("Ejercicio 03 - PUT (Actualización por DNI)", "/persons/{dni}");

        return index;
    }
}