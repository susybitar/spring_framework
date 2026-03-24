package com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_intro_spring.beans;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Bean que representa a una persona para el Ejercicio 2.
 * Contiene la informacion basica requerida: nombre, apellidos, fecha de nacimiento y sexo.
 */
@JsonPropertyOrder({"firstName", "lastName", "secondLastName", "fullName", "birthDate", "gender"})
public class Person {

    /** Nombre de pila de la persona. */
    private String firstName;

    /** Primer apellido de la persona. */
    private String lastName;

    /** Segundo apellido de la persona. */
    private String secondLastName;

    /** Nombre completo de la persona. */
    private String fullName;

    /** Fecha de nacimiento en formato DD/MM/YYYY. */
    private String birthDate;

    /** Genero o sexo de la persona. */
    private String gender;

    // Metodos Getter y Setter para el acceso a los datos del Bean

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}