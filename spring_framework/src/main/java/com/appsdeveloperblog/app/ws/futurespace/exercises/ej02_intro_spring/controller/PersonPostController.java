package com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_intro_spring.controller;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_intro_spring.beans.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar las peticiones del Ejercicio 2.
 * Validado para asegurar que los datos recibidos por URL son correctos.
 */
@RestController
@RequestMapping("/envioFormulario")
@Validated // Permite que las validaciones de @RequestParam funcionen
public class PersonPostController {

    /** Almacen en memoria para la persona guardada. */
    private Person storedPerson;

    /**
     * Metodo POST que recibe y valida parametros directamente desde la URL.
     * @param firstName Nombre (No puede estar vacio).
     * @param lastName Apellido (Minimo 2 caracteres).
     * @param secondLastName Segundo apellido.
     * @param birthDate Fecha de nacimiento.
     * @param gender Genero.
     * @return ResponseEntity con codigo 201 si es exitoso.
     */
    @PostMapping(produces = "text/plain")
    public ResponseEntity<String> savePerson(
            @RequestParam @NotBlank(message = "El nombre es obligatorio") @Size(min = 2) String firstName,
            @RequestParam @NotBlank(message = "El primer apellido es obligatorio") @Size(min = 2) String lastName,
            @RequestParam @NotBlank(message = "El segundo apellido es obligatorio") @Size(min = 2) String secondLastName,
            @RequestParam @NotBlank(message = "La fecha es obligatoria") String birthDate,
            @RequestParam @NotBlank(message = "El genero es obligatorio") String gender
    ) {
        Person dataPerson = new Person();

        dataPerson.setFirstName(firstName);
        dataPerson.setLastName(lastName);
        dataPerson.setSecondLastName(secondLastName);
        dataPerson.setBirthDate(birthDate);
        dataPerson.setGender(gender);
        dataPerson.setFullName(firstName + " " + lastName + " " + secondLastName);

        this.storedPerson = dataPerson;

        // EJERCICIO OPCIONAL 2: Logs en consola
        System.out.println("El usuario " + dataPerson.getFirstName() + " ha realizado la accion: Guardado de datos POST");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Datos de " + dataPerson.getFirstName() + " guardados con exito.");
    }

    /**
     * Metodo GET para consultar la persona almacenada.
     * @return El objeto Person en formato JSON.
     */
    @GetMapping
    public Person getStoredPerson() {
        return this.storedPerson;
    }
}