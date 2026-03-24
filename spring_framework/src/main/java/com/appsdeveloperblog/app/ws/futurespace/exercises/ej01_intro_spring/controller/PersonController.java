package com.appsdeveloperblog.app.ws.futurespace.exercises.ej01_intro_spring.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej01_intro_spring.beans.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para gestionar las peticiones del Ejercicio 1.
 * Se encarga de exponer los endpoints relacionados con la entidad Persona.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    /**
     * Método GET que retorna los datos de una persona en formato JSON.
     * Según el enunciado, se utiliza un bean (Person) para almacenar la información.
     * * @return Objeto Person con los datos precargados listos para ser devueltos en la respuesta.
     */
    @GetMapping
    public Person getPersonDetails() {

        // Instanciamos el bean Person para el Ejercicio 1
        Person person = new Person();

        // Seteamos los valores requeridos evitando acentos y caracteres especiales
        person.setFirstName("Susana");
        person.setLastName("Bitar");
        person.setSecondLastName("Azevedo");
        person.setFullName("Susana Bitar Azevedo");
        person.setBirthDate("13/11/1995");
        person.setGender("Female");

        // EJERCICIO OPCIONAL 2: Log con el formato requerido
        System.out.println("El usuario " + person.getFirstName() + " ha realizado la accion: Consulta de datos GET");

        // Retornamos el objeto para que Spring lo muestre como JSON en pantalla
        return person;
    }
}