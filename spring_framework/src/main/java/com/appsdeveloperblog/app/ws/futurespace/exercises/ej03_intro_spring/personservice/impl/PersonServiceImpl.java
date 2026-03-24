package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.personservice.impl;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.beans.PeopleList;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.exceptions.PersonServiceException;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.request.UpdatePersonRequestModel;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.response.Person;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.personservice.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementacion del servicio para la gestion de personas.
 * Centraliza la logica de negocio y el acceso a los datos almacenados en memoria.
 */
@Service
public class PersonServiceImpl implements PersonService {

    /** Inyeccion de la lista compartida que contiene las 10 personas iniciales. */
    private final PeopleList peopleList;

    /**
     * Constructor para la inyeccion de dependencias.
     * Spring se encarga de pasarle el Bean PeopleList automaticamente.
     * @param peopleList Bean con la lista de personas.
     */
    public PersonServiceImpl(PeopleList peopleList) {
        this.peopleList = peopleList;
    }

    /**
     * Devuelve el listado completo de personas del archivador.
     * @return Una lista de objetos Person.
     */
    @Override
    public List<Person> getAllPeople() {
        return peopleList.getPersonList();
    }

    /**
     * Busca una persona especifica recorriendo la lista por DNI.
     * @param dni El identificador a buscar.
     * @return El objeto Person si se encuentra la coincidencia.
     * @throws PersonServiceException Si el DNI no existe en el listado.
     */
    @Override
    public Person getPersonByDni(String dni) {
        for (Person p : peopleList.getPersonList()) {
            if (p.getDni().equalsIgnoreCase(dni)) {
                return p;
            }
        }
        throw new PersonServiceException("No se encontro ninguna persona con el DNI: " + dni);
    }

    /**
     * Actualiza los datos de una persona basandose en la informacion del RequestModel.
     * @param personDetails Objeto con los nuevos datos que vienen de la peticion.
     * @return El objeto Person ya actualizado.
     * @throws PersonServiceException Si el DNI a actualizar no existe.
     */
    @Override
    public Person updatePerson(UpdatePersonRequestModel personDetails) {
        for (Person p : peopleList.getPersonList()) {
            if (p.getDni().equalsIgnoreCase(personDetails.getDni())) {
                p.setFirstName(personDetails.getFirstName());
                p.setLastName(personDetails.getLastName());
                p.setSecondLastName(personDetails.getSecondLastName());
                p.setBirthDate(personDetails.getBirthDate());
                p.setGender(personDetails.getGender());
                return p;
            }
        }
        throw new PersonServiceException("No se puede actualizar: El DNI " + personDetails.getDni() + " no existe.");
    }
}