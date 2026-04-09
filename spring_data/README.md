# Spring Data JPA - Persistencia, Consultas Avanzadas y Gestión de Personas

Este módulo contiene la implementación de la capa de persistencia para el sistema de gestión bibliotecaria y un sistema
integral de gestión de personas con validaciones REST.

## Estructura del Módulo

El código se organiza siguiendo el patrón de repositorio y servicios de Spring:

- **[Entidades](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej02_jpa/entities/)**: Definición del
  modelo de datos con JPA (`Book`, `Author`, `Publisher`, `Category`). Incluye el modelo
  de [Personas](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej02_jpa/entities/Person.java) con
  validaciones Jakarta.
- **[Repositorios](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej03_jpa/repositories/)**:
  Interfaces que extienden de `JpaRepository`, incluyendo la gestión de persistencia para ciudadanos.
-
    *
*[Controladores (API REST)](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej03_jpa/controllers/PersonController.java)
**: Implementación de endpoints para el CRUD de personas y manejo de excepciones (Ejercicios Opcionales).
- **[Utilidades](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej03_jpa/util/)**: Clase
  `DataInitializer` encargada de poblar la base de datos automáticamente al arrancar la aplicación.

## Implementación de Consultas (Query Engine)

Se han desarrollado diferentes estrategias para la recuperación de datos, destacando los siguientes componentes:

- **Consultas Personalizadas**: Uso de la anotación `@Query` para lógica JPQL específica. Ver ejemplo
  en [BookRepository.java](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej03_jpa/repositories/BookRepository.java).
- **Derivación de Consultas**: Implementación de **Query Methods** para filtros automáticos. Ver ejecución
  en [FindBooksMethodQuery.java](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej05_jpa/FindBooksMethodQuery.java).
- **Consultas Multivariable**: Desarrollo avanzado de métodos con navegación de propiedades y operadores lógicos. Ver
  ejecución
  en [FindBooksMultiQuery.java](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej06_jpa/FindBooksMultiQuery.java).

## Gestión de Personas y Validaciones (Ejercicios Opcionales)

Se ha implementado un sistema robusto para la gestión de ciudadanos con control estricto de errores y validaciones en
tiempo real:

- **Validación Jakarta**: Uso de `@NotBlank`, `@Past` y `@Size` para asegurar la integridad en el DNI, nombres y fechas.
- **Manejo de Excepciones**:
  El [GlobalExceptionHandler.java](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej03_jpa/exceptions/GlobalExceptionHandler.java)
  centraliza las respuestas 400 (Bad Request) y 404 (Not Found).
- **Documentación de Pruebas**: Se incluye la [Colección de Postman](./spring_data.postman_collection.json) con todos
  los casos de éxito y error organizados por carpetas.

## Características Técnicas

- **Nomenclatura CamelCase**: Consistencia total con los estándares de Java.
- **Robustez en Búsquedas**: Implementación de `IgnoreCase` para evitar problemas con mayúsculas/minúsculas.
- **Documentación JavaDoc**: Todas las firmas de los métodos están documentadas detallando su propósito y parámetros.

## Visualización de Resultados

La aplicación permite verificar los resultados a través de dos vías:

1. **Consola del servidor**: Para filtros bibliotecarios (años, ISBN, editoriales).
2. **Postman**: Para la validación de la API REST de personas y control de excepciones.

---
**Desarrollado por:** Susana Bitar