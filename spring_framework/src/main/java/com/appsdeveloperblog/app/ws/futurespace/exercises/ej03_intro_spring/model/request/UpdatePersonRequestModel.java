package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Modelo para la actualizacion de personas.
 * Esta clase separa los datos de entrada de la API del modelo interno Person,
 * permitiendo aplicar reglas de validacion especificas para el protocolo HTTP.
 */
public class UpdatePersonRequestModel {

    /** Identificador unico que no debe cambiar, requerido para localizar el registro. */
    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "^[0-9]{8}[A-Z]$", message = "Formato de DNI invalido (Ej: 12345678Z)")
    private String dni;

    /** Nombre de pila con validacion de longitud. */
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String firstName;

    /** Primer apellido con validacion de longitud. */
    @NotBlank(message = "El primer apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El primer apellido debe tener entre 2 y 50 caracteres")
    private String lastName;

    /** Segundo apellido con validacion de longitud. */
    @NotBlank(message = "El segundo apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El segundo apellido debe tener entre 2 y 50 caracteres")
    private String secondLastName;

    /** Validacion mediante expresion regular para cumplir estrictamente con el formato de fecha. */
    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$",
            message = "La fecha debe tener formato DD/MM/YYYY")
    private String birthDate;

    /** Genero de la persona. */
    @NotBlank(message = "El genero es obligatorio")
    private String gender;

    // Getters y Setters necesarios para Jackson

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSecondLastName() { return secondLastName; }
    public void setSecondLastName(String secondLastName) { this.secondLastName = secondLastName; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}