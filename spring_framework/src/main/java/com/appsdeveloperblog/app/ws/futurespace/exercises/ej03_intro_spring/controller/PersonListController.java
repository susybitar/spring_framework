package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.request.UpdatePersonRequestModel;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.response.Person;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.personservice.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que actua como punto de entrada de la API.
 * Delega toda la logica de negocio al servicio PersonService.
 */
@RestController
@RequestMapping("/listadoPersonas")
public class PersonListController {

    /** Servicio inyectado para gestionar la logica de negocio. */
    private final PersonService personService;

    /**
     * Constructor para la inyeccion de dependencias.
     * @param personService Interfaz del servicio de personas.
     */
    public PersonListController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Obtiene el listado completo de todas las personas.
     * @return Una lista de objetos Person con estado 200 OK.
     */
    @GetMapping(produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> list = personService.getAllPeople();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Busca una persona por su DNI.
     * El error 404 lo gestiona el GlobalExceptionsHandler si el servicio lanza la excepcion.
     * @param dni El identificador de la persona a buscar.
     * @return Objeto Person con estado 200 OK.
     */
    @GetMapping(path = "/{dni}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Person> getPersonByDni(@PathVariable String dni) {
        Person person = personService.getPersonByDni(dni);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    /**
     * Actualiza los datos de una persona.
     * Usamos Valid para que Spring compruebe el RequestModel antes de procesar la peticion.
     * @param updatedPerson Objeto RequestBody con los datos validados a actualizar.
     * @return Objeto Person actualizado con estado 200 OK.
     */
    @PutMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<Person> updatePerson(@Valid @RequestBody UpdatePersonRequestModel updatedPerson) {

        Person person = personService.updatePerson(updatedPerson);

        // EJERCICIO OPCIONAL 2: Log en consola con formato obligatorio
        System.out.println("El usuario " + updatedPerson.getFirstName() + " ha realizado la accion: Actualizacion de datos PUT");

        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}