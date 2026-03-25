# Clean Code & Refactorización

Este repositorio centraliza la implementación de ejercicios prácticos enfocados en la calidad de software, aplicando principios **SOLID**, **Clean Code** y **Patrones de Diseño**. El objetivo es demostrar la capacidad de transformar requisitos funcionales en sistemas robustos, mantenibles y desacoplados.

## Estándares Técnicos Aplicados

A lo largo del proyecto se han implementado de forma rigurosa los siguientes estándares:

### 1. Principios SOLID
* **Single Responsibility Principle (SRP):** Cada clase tiene una única razón para cambiar. Por ejemplo, el cálculo de aciertos se delega exclusivamente a un evaluador, separándolo del flujo de la partida.
* **Dependency Injection (DI):** En el proyecto Mastermind, las dependencias (como el código secreto) se inyectan mediante constructor para facilitar el testing unitario y reducir el acoplamiento.

### 2. Clean Code & Refactoring
* **Names vs. Comments:** El código es autodocumentado mediante nombres de variables y métodos semánticos, reduciendo la necesidad de comentarios explicativos innecesarios.
* **Encapsulamiento y Ocultamiento de Información:** Uso estricto de modificadores de acceso (`private`, `final`) y devolución de copias defensivas o vistas inmodificables para proteger el estado interno de los objetos.
* **Single Level of Abstraction:** Los métodos han sido refactorizados para mantener un nivel de abstracción coherente, extrayendo la lógica compleja a métodos privados.

### 3. Robustez y Tipado
* **Fail-Fast & Guard Clauses:** Uso de validaciones al inicio de los métodos para evitar estados inconsistentes.
* **Type Safety:** Implementación de `Enums` bilingües y contenedores `Optional<T>` para eliminar los riesgos asociados a valores nulos y entradas de usuario no controladas.

## Estructura de Proyectos

### [Ejercicio 06 - Mastermind Engine](src/exercises/ejercicio06/)
Este es el proyecto más avanzado del repositorio. Se trata de un motor de juego completo que destaca por:
* **Separación de Capas:** Arquitectura desacoplada donde la lógica de negocio es totalmente independiente de la interfaz de consola (MVC).
* **Algoritmo de Evaluación:** Implementación de un sistema de "marcado" mediante arrays booleanos para garantizar la precisión matemática en casos de colores duplicados.
* **Inmutabilidad:** Protección del código secreto mediante `Collections.unmodifiableList`.
