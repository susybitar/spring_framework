package com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.ej01_jpa_opcional.config;

import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.ej01_jpa_opcional.entities.Person;
import com.appsdeveloperblog.app.ws.futurespace.exercises.exercises_opcionales.ej01_jpa_opcional.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

/**
 * Configuracion para inicializar datos en la base de datos al arrancar la aplicacion.
 */
@Configuration
public class InitializerData {

    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        return args -> {
            // Solo insertamos si la base de datos está vacía
            if (repository.count() == 0) {

                // Creamos el objeto usando el constructor
                Person susana = new Person(
                        "12345678Z",
                        "Susana",
                        "Bitar",
                        "Azevedo",
                        LocalDate.of(1995, 11, 13),
                        "M"
                );

                // Lo guardamos en la base de datos
                repository.save(susana);

                // Imprimimos el log usando getFullName()
                // Al haber asignado ya nombre y apellidos arriba, getFullName() los juntará correctamente
                System.out.println("Base de datos inicializada: Usuario " + susana.getFullName() + " guardado correctamente");
            }
        };
    }
}