package com.appsdeveloperblog.app.ws.futurespace.exercises.ej03_jpa.repositories;

import com.appsdeveloperblog.app.ws.futurespace.exercises.ej02_jpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad Book.
 * Proporciona métodos CRUD gracias a la herencia de JpaRepository.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Ejercicio JPA 4: Busca y devuelve los libros publicados después de una fecha exacta.
     * Utiliza el parámetro dinámico :fechaLimite.
     *
     * @param fechaLimite Fecha a partir de la cual se buscarán los libros.
     * @return Lista de libros publicados después de la fecha indicada.
     */
    @Query(
            value = "SELECT book FROM Book book WHERE book.publicationDate > :fechaLimite"
    )
    List<Book> findBooksAfterDate(@Param("fechaLimite") LocalDate fechaLimite);

    /**
     * Ejercicio JPA 5: Busca y devuelve los libros publicados después de una fecha exacta.
     * Utiliza la derivación de consultas de Spring Data JPA (Query Method)
     * basada en el nombre del método.
     *
     * @param date Fecha límite para la búsqueda.
     * @return Lista de libros cuya fecha de publicación es posterior a la indicada.
     */
    List<Book> findByPublicationDateAfter(LocalDate date);

    /**
     * Ejercicio JPA 6.1: Busca libros publicados en un año específico.
     * Al usar LocalDate, definimos un rango que abarca desde el 1 de enero
     * hasta el 31 de diciembre del año deseado.
     *
     * @param start Fecha de inicio del rango (ej: 2001-01-01).
     * @param end   Fecha de fin del rango (ej: 2001-12-31).
     * @return Lista de libros publicados en ese intervalo de tiempo.
     */

    List<Book> findByPublicationDateBetween(LocalDate start, LocalDate end);

    /**
     * Ejercicio JPA 6.2: Busca un libro por su código ISBN.
     * Se devuelve un único objeto Book ya que el ISBN es un identificador único.
     *
     * @param isbn Código ISBN del libro a buscar.
     * @return El libro encontrado o null si no existe.
     */
    Book findByIsbn(String isbn);

    /**
     * Ejercicio JPA 6.3: Busca libros por nombre de editorial ignorando mayúsculas/minúsculas.
     *
     * @param publisherName Nombre de la editorial (ej: "RBA" o "rba").
     * @return Lista de libros asociados.
     */
    List<Book> findByPublisher_PublisherNameIgnoreCase(String publisherName);

    /**
     * Ejercicio JPA 6.4: Busca libros de una editorial (ignore case) en un año concreto.
     *
     * @param publisherName Nombre de la editorial.
     * @param start         Inicio del año.
     * @param end           Fin del año.
     * @return Lista de libros que cumplen ambas condiciones.
     */
    List<Book> findByPublisher_PublisherNameIgnoreCaseAndPublicationDateBetween(String publisherName, LocalDate start, LocalDate end);

}