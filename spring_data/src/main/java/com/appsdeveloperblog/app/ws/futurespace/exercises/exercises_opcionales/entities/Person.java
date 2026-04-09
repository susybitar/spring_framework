package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

/**
 * Entidad que representa a una persona en el sistema.
 * Se utiliza para el Ejercicio 1 (GET) y el Ejercicio 3 (PUT) de la sección opcional.
 * Incluye validaciones de Bean Validation para asegurar la integridad de los datos.
 */
@Entity
@Table(name = "persons")
public class Person {

    /**
     * Identificador único autoincremental de la persona.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id;

    /**
     * DNI con validación de formato.
     */
    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "^[0-9]{8}[TRWAGMYFPDXBNJZSTQVHLCKE]$", message = "Formato de DNI no válido")
    @Column(name = "dni", unique = true, length = 9, nullable = false)
    private String dni;

    /**
     * Nombre de pila de la persona.
     */
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Primer apellido de la persona.
     */
    @NotBlank(message = "El primer apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El primer apellido debe tener entre 2 y 50 caracteres")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Segundo apellido de la persona.
     */
    @NotBlank(message = "El segundo apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El segundo apellido debe tener entre 2 y 50 caracteres")
    @Column(name = "second_last_name", nullable = false)
    private String secondLastName;

    /**
     * Nombre completo calculado dinámicamente.
     * No se persiste en base de datos al ser un campo derivado.
     */
    @Transient
    private String fullName;

    /**
     * Fecha de nacimiento, debe ser obligatoriamente una fecha del pasado.
     */
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    /**
     * Sexo de la persona (H para Hombre, M para Mujer).
     */
    @NotBlank(message = "El sexo es obligatorio")
    @Pattern(regexp = "^[HM]$", message = "El sexo debe ser 'H' (Hombre) o 'M' (Mujer)")
    @Column(name = "gender", nullable = false)
    private String gender;

    /**
     * Constructor por defecto requerido por JPA.
     */
    public Person() {
    }

    /**
     * Constructor con parámetros para facilitar la creación de instancias.
     * El ID no se incluye ya que es autogenerado por la base de datos.
     *
     * @param dni            DNI.
     * @param firstName      Nombre de pila.
     * @param lastName       Primer apellido.
     * @param secondLastName Segundo apellido.
     * @param birthDate      Fecha de nacimiento.
     * @param gender         Sexo.
     */
    public Person(String dni, String firstName, String lastName, String secondLastName, LocalDate birthDate, String gender) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    /**
     * Obtiene el nombre completo concatenando nombre y apellidos.
     *
     * @return String con el nombre completo formateado.
     */
    public String getFullName() {
        return String.format("%s %s %s",
                firstName != null ? firstName : "",
                lastName != null ? lastName : "",
                secondLastName != null ? secondLastName : "").trim();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}