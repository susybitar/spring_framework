package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.repositories;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio de persistencia para la entidad Person.
 * Proporciona las operaciones CRUD básicas gracias a JpaRepository.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Busca una persona en la base de datos por su DNI.
     * Utilizado principalmente para el Ejercicio 3 (Actualización).
     *
     * @param dni Documento de identidad a buscar.
     * @return Un Optional que contiene la persona si es encontrada.
     */
    Optional<Person> findByDni(String dni);
}