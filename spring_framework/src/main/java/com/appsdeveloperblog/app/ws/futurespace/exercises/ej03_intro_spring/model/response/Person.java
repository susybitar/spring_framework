package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_intro_spring.model.response;

/**
 * Clase de datos interna del Ejercicio 3.
 * Representa como se guarda a una persona en la lista.
 */
public class Person {

    private String dni;
    private String firstName;
    private String lastName;
    private String secondLastName;
    private String birthDate;
    private String gender;

    /**
     * Constructor vacio necesario para que Spring instancie el Bean correctamente.
     */
    public Person() {
    }

    /**
     * Constructor con parametros para inicializar la informacion.
     * @param dni DNI de la persona.
     * @param firstName Nombre de pila.
     * @param lastName Primer apellido.
     * @param secondLastName Segundo apellido.
     * @param birthDate Fecha de nacimiento.
     * @param gender Genero de la persona.
     */
    public Person(String dni, String firstName, String lastName, String secondLastName, String birthDate, String gender) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

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