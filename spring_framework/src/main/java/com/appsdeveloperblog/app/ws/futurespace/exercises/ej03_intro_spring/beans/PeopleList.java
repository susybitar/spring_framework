package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.beans;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.response.Person;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean encargado de gestionar el listado de personas en memoria.
 * Al usar Component, Spring lo detecta automaticamente y lo mantiene
 * disponible para ser inyectado en el controlador.
 */
@Component
public class PeopleList {

    /** Lista principal que actua como base de datos temporal durante la ejecucion. */
    private List<Person> personList = new ArrayList<>();

    /**
     * Constructor del bean donde inicializamos el estado de la aplicacion.
     * Creamos 10 registros ficticios para cumplir con los requisitos del ejercicio
     * y facilitar las pruebas de busqueda y actualizacion.
     */
    public PeopleList() {
        personList.add(new Person("11111111A", "Ana", "Garcia", "Perez", "12/05/1990", "Mujer"));
        personList.add(new Person("22222222B", "Juan", "Lopez", "Martinez", "25/03/1985", "Hombre"));
        personList.add(new Person("33333333C", "Maria", "Rodriguez", "Sanchez", "10/11/1992", "Mujer"));
        personList.add(new Person("44444444D", "Carlos", "Perez", "Gomez", "05/02/1980", "Hombre"));
        personList.add(new Person("55555555E", "Laura", "Mesa", "Ruiz", "30/08/1995", "Mujer"));
        personList.add(new Person("66666666F", "Diego", "Castro", "Vila", "14/07/1988", "Hombre"));
        personList.add(new Person("77777777G", "Elena", "Sanz", "Moya", "21/12/1993", "Mujer"));
        personList.add(new Person("88888888H", "Pablo", "Ortega", "Cano", "02/06/1982", "Hombre"));
        personList.add(new Person("99999999I", "Sara", "Blanco", "Ferrer", "18/09/1991", "Mujer"));
        personList.add(new Person("00000000J", "Marcos", "Leon", "Soto", "22/01/1987", "Hombre"));
    }

    /**
     * Metodo getter para que el controlador pueda consultar y filtrar sobre esta lista.
     * @return Lista de objetos Person almacenados en memoria.
     */
    public List<Person> getPersonList() {
        return personList;
    }
}