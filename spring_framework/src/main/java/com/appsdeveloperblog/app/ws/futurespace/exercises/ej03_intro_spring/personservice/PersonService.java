package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.personservice;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.request.UpdatePersonRequestModel;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.response.Person;

import java.util.List;

/**
 * Interfaz que define los servicios para la entidad Person.
 * Sigue el principio de abstraccion: el controlador sabe QUE se puede hacer,
 * pero no COMO se implementa la logica.
 */
public interface PersonService {

    /**
     * Define la operacion para obtener el listado completo de personas.
     * @return Lista de personas almacenadas.
     */
    List<Person> getAllPeople();

    /**
     * Define la operacion de busqueda de una persona mediante su identificador unico (DNI).
     * @param dni Identificador de la persona a buscar.
     * @return Objeto Person con los datos encontrados.
     */
    Person getPersonByDni(String dni);

    /**
     * Define la operacion de actualizacion de los datos de una persona existente.
     * @param personDetails Modelo validado con los nuevos datos recibidos en la peticion.
     * @return Objeto Person resultante tras la actualizacion.
     */
    Person updatePerson(UpdatePersonRequestModel personDetails);
}