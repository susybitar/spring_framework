package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_jpa.util;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_jpa.entities.*;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_jpa.repositories.AuthorRepository;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_jpa.repositories.BookRepository;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_jpa.repositories.CategoryRepository;
import com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_jpa.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase encargada de inicializar la base de datos con los datos oficiales del ejercicio.
 * Utiliza los repositorios para insertar temáticas, editoriales, autores y libros.
 */
@Component
@Order(1)
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final CategoryRepository categoryRepo;
    private final PublisherRepository publisherRepo;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param bookRepo      Repositorio de libros.
     * @param authorRepo    Repositorio de autores.
     * @param categoryRepo  Repositorio de categorías.
     * @param publisherRepo Repositorio de editoriales.
     */
    public DataInitializer(BookRepository bookRepo, AuthorRepository authorRepo,
                           CategoryRepository categoryRepo, PublisherRepository publisherRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
        this.publisherRepo = publisherRepo;
    }

    /**
     * Ejecuta la carga de datos al arrancar la aplicación.
     *
     * @param args Argumentos de consola.
     * @throws Exception Si ocurre un error en la persistencia.
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">> Cargando datos oficiales del catálogo...");

        // Limpieza previa para evitar duplicados realizando las pruebas necesarias

        bookRepo.deleteAll();
        authorRepo.deleteAll();
        publisherRepo.deleteAll();
        categoryRepo.deleteAll();

        // Categorias
        Category c1 = categoryRepo.save(new Category("Historia"));
        Category c2 = categoryRepo.save(new Category("Novela"));
        Category c3 = categoryRepo.save(new Category("Informática"));

        // Editoriales
        Publisher e1 = publisherRepo.save(new Publisher("Planeta", "Grupo Planeta S.A."));
        Publisher e2 = publisherRepo.save(new Publisher("O'Reilly", "O'Reilly Media Inc."));
        Publisher e3 = publisherRepo.save(new Publisher("RBA", "RBA Libros S.A."));

        // Autores
        Author a1 = authorRepo.save(new Author("Francisco", "Diaz Diaz", LocalDate.of(1970, 5, 12)));
        Author a2 = authorRepo.save(new Author("Alberto", "Miguelez Lopez", LocalDate.of(1982, 3, 25)));
        Author a3 = authorRepo.save(new Author("Raúl", "Ochandiano Rivera", LocalDate.of(1990, 11, 2)));
        Author a4 = authorRepo.save(new Author("Fernando", "Martos Etxeberria", LocalDate.of(1975, 8, 14)));
        Author a5 = authorRepo.save(new Author("Joanne", "Rowling", LocalDate.of(1965, 7, 31)));
        Author a6 = authorRepo.save(new Author("Miguel", "Limón Ignacio", LocalDate.of(1968, 12, 1)));
        Author a7 = authorRepo.save(new Author("David", "Mozas Jerez", LocalDate.of(1988, 6, 20)));

        // Libros
        bookRepo.saveAll(List.of(
                new Book("87919878", "Historia de Alemania", LocalDate.of(2001, 1, 1), a1, e1, c1),
                new Book("978-02", "Historia de España", LocalDate.of(2002, 1, 1), a1, e1, c1),
                new Book("978-03", "Historia de Francia", LocalDate.of(2002, 1, 1), a1, e1, c1),
                new Book("978-04", "La sociedad medieval", LocalDate.of(2001, 1, 1), a2, e1, c1),
                new Book("978-05", "Angular desde 0", LocalDate.of(2013, 1, 1), a3, e2, c3),
                new Book("978-06", "Crepúsculo Vampiros", LocalDate.of(1999, 1, 1), a4, e3, c2),
                new Book("978-07", "Crepúsculo Zombies", LocalDate.of(1998, 1, 1), a4, e3, c2),
                new Book("978-08", "Crepúsculo Monsters", LocalDate.of(1997, 1, 1), a4, e3, c2),
                new Book("978-09", "Harry Potter I", LocalDate.of(2000, 1, 1), a5, e3, c2),
                new Book("978-10", "Harry Potter II", LocalDate.of(2001, 1, 1), a5, e3, c2),
                new Book("978-11", "Harry Potter III", LocalDate.of(2001, 1, 1), a5, e3, c2),
                new Book("978-12", "Harry Potter IV", LocalDate.of(2002, 1, 1), a5, e3, c2),
                new Book("978-13", "La sociedad industrial", LocalDate.of(1972, 1, 1), a2, e1, c1),
                new Book("978-14", "Los templarios", LocalDate.of(1998, 1, 1), a6, e1, c1),
                new Book("978-15", "Los albigenses", LocalDate.of(1986, 1, 1), a6, e1, c1),
                new Book("978-16", "Los godos", LocalDate.of(2001, 1, 1), a6, e1, c1),
                new Book("978-17", "Spring", LocalDate.of(2014, 1, 1), a7, e2, c3),
                new Book("978-18", "JQuery", LocalDate.of(2015, 1, 1), a7, e2, c3),
                new Book("978-19", "MySQL", LocalDate.of(2016, 1, 1), a7, e2, c3),
                new Book("978-20", "Oracle", LocalDate.of(2003, 1, 1), a7, e2, c3)
        ));

        System.out.println(">> ¡Base de datos poblada correctamente!");
    }
}