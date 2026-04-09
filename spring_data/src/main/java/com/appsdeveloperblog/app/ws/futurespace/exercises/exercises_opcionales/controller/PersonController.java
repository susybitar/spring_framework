package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.entities.Person;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.repositories.PersonRepository;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.exceptions.PersonServiceException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gestionar las peticiones (Version Spring Data).
 * Centraliza la exposicion del recurso 'persons' obteniendo los datos desde la base de datos.
 * Incluye logica robusta para el manejo de estados vacios y auditoria por consola.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    /**
     * Inyeccion de dependencias del repositorio de personas.
     *
     * @param personRepository Repositorio JPA para el acceso a datos.
     */
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Obtiene el listado completo de personas registradas en el sistema.
     * Soporta representaciones en JSON y XML.
     * Si la base de datos no contiene registros, se lanza una excepcion de servicio
     * que es capturada globalmente para retornar un error 404 estructurado.
     * * @return Lista de entidades Person persistidas.
     *
     * @throws PersonServiceException Si la lista de personas esta vacia.
     */
    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public List<Person> getPersonDetails() {

        // Consultamos todos los registros a traves de Spring Data JPA
        List<Person> persons = personRepository.findAll();

        // Si no hay datos, lanzamos error controlado
        if (persons.isEmpty()) {
            throw new PersonServiceException("No se han encontrado registros de personas en la base de datos. La tabla esta vacia.");
        }

        // Log de auditoria por consola
        // Mostramos el nombre completo del primer registro para confirmar la accion
        System.out.println("El usuario " + persons.get(0).getFullName() + " ha realizado la accion: Consulta de datos GET");

        return persons;
    }
}