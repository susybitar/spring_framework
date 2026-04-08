# Spring Data JPA - Persistencia y Consultas Avanzadas

Este módulo contiene la implementación de la capa de persistencia para el sistema de gestión bibliotecaria. Se centra en
el uso de **Spring Data JPA** para interactuar con una base de datos relacional (MySQL), gestionando entidades complejas
y optimizando la recuperación de información mediante diversos tipos de consultas.

## Estructura del Módulo

El código se organiza siguiendo el patrón de repositorio y servicios de Spring:

- **[Entidades](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej02_jpa/entities/)**: Definición del
  modelo de datos con JPA (`Book`, `Author`, `Publisher`, `Category`). Incluye relaciones **Many-To-One** y *
  *One-To-Many**.
- **[Repositorios](./src/main/java/com/appsdeveloperblog/app/ws/futurespace/exercises/ej03_jpa/repositories/)**:
  Interfaces que extienden de `JpaRepository`, donde se implementan las estrategias de consulta.
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

## Características Técnicas

- **Nomenclatura CamelCase**: Consistencia total con los estándares de Java.
- **Robustez en Búsquedas**: Implementación de `IgnoreCase` para evitar problemas con mayúsculas/minúsculas.
- **Documentación JavaDoc**: Todas las firmas de los métodos están documentadas detallando su propósito y parámetros.

## Visualización de Resultados

La aplicación muestra los resultados por la consola del servidor de forma estructurada para verificar:

1. Filtros por año de publicación.
2. Búsquedas por ISBN único.
3. Filtrado por editoriales específicas.

---
**Desarrollado por:** Susana Bitar