package com.appsdeveloperblog.app.ws.futurespace.exercises.ej06_jpa;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_jpa.entities.Book;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_jpa.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Clase encargada de ejecutar y mostrar los resultados del Ejercicio 6.
 * Realiza múltiples consultas variadas (Query Methods) sobre el catálogo de libros.
 */
@Component
@Order(4) // Se ejecuta después del Ejercicio 5
public class FindBooksMultiQuery implements CommandLineRunner {

    private final BookRepository bookRepository;

    public FindBooksMultiQuery(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n---------------------------------------------------------");
        System.out.println("                 RESULTADO EJERCICIO 6                   ");
        System.out.println("        (Consultas variadas usando Query Methods)        ");
        System.out.println("---------------------------------------------------------");

        // 6.1: Mostrar los libros publicados en el año 2001
        System.out.println(">>> 6.1: Libros publicados en el año 2001:");
        bookRepository.findByPublicationDateBetween(
                LocalDate.of(2001, 1, 1),
                LocalDate.of(2001, 12, 31)
        ).forEach(book -> {
            System.out.println("Libro: " + book.getTitle() + " | Fecha: " + book.getPublicationDate());
        });

        // 6.2: Mostrar el libro cuyo ISBN es el 87919878
        System.out.println("\n>>> 6.2: Libro con ISBN 87919878:");
        Book bookIsbn = bookRepository.findByIsbn("87919878");
        if (bookIsbn != null) {
            System.out.println("Libro: " + bookIsbn.getTitle() + " | ISBN: " + bookIsbn.getIsbn());
        }

        // 6.3: Mostrar los libros de la editorial RBA
        System.out.println("\n>>> 6.3: Libros de la editorial RBA:");
        bookRepository.findByPublisher_PublisherNameIgnoreCase("RBA").forEach(book -> {
            System.out.println("Libro: " + book.getTitle() + " | Editorial: " + book.getPublisher().getPublisherName());
        });

        // 6.4: Mostrar los libros de la editorial PLANETA publicados en 1986
        System.out.println("\n>>> 6.4: Libros de PLANETA publicados en 1986:");
        bookRepository.findByPublisher_PublisherNameIgnoreCaseAndPublicationDateBetween(
                "PLANETA",
                LocalDate.of(1986, 1, 1),
                LocalDate.of(1986, 12, 31)
        ).forEach(book -> {
            System.out.println("Libro: " + book.getTitle() + " | Fecha: " + book.getPublicationDate());
        });

        System.out.println("---------------------------------------------------------\n");
    }
}