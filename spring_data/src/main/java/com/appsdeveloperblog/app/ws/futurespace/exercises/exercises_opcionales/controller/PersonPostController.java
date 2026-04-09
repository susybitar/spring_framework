package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.entities.Person;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.repositories.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de procesar las altas de nuevas personas (Ejercicio Opcional 2).
 * Utiliza @ModelAttribute para vincular los parámetros de la URL directamente con
 * la entidad Person, permitiendo la validación automática de los campos.
 */
@RestController
@RequestMapping("/persons")
public class PersonPostController {

    private final PersonRepository personRepository;

    /**
     * Inyección de dependencias mediante constructor.
     *
     * @param personRepository El repositorio JPA para acceder a la base de datos MySQL.
     */
    public PersonPostController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Procesa el envío de un formulario capturando datos por parámetros de consulta (Query Params).
     * URL de ejemplo: /persons/envioFormulario?dni=12345678Z&firstName=Susana&lastName=Bitar...
     * El uso de @Valid asegura que se cumplan las restricciones (@NotNull, @Size, @Pattern)
     * definidas en la clase de entidad Person.
     *
     * @param person Objeto Person construido y validado automáticamente por Spring desde los parámetros de la URL.
     * @return Objeto Person persistido en la base de datos con su ID generado.
     */
    @PostMapping(value = "/envioFormulario",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
            })
    @ResponseStatus(HttpStatus.CREATED) // Retornamos 201 Created para indicar éxito en la creación
    public Person processForm(@Valid @ModelAttribute Person person) {

        // Persistencia en MySQL: Gracias a @ModelAttribute, 'person' ya tiene los datos de la URL.
        // Spring Data JPA se encarga de convertir el objeto en una sentencia INSERT.
        Person savedPerson = personRepository.save(person);

        // Log de auditoria por consola
        System.out.println("El usuario " + savedPerson.getFullName() + " ha realizado la accion: Envio de Formulario POST");

        return savedPerson;
    }
}