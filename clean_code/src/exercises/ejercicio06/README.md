# Mastermind Java - Juego de Lógica Profesional

Este proyecto es una implementación completa del juego Mastermind. Se ha desarrollado poniendo especial énfasis en la **calidad del código** y en la **separación de responsabilidades**, asegurando que el motor del juego sea independiente de la interfaz de usuario.

## Características Técnicas

Para este ejercicio, se han aplicado conceptos avanzados de programación orientada a objetos:

* **Arquitectura Desacoplada (MVC):** La lógica de las reglas (`MastermindGame`) y el cálculo de aciertos (`MoveEvaluator`) no dependen de la consola. Esto permitiría cambiar la interfaz de texto por una gráfica sin tocar el motor del juego.
* **Gestión de Colores Repetidos:** El algoritmo de evaluación utiliza un sistema de marcas (arrays booleanos) para garantizar que los aciertos de posición (blancas) y de color (negras) se cuenten con total precisión, incluso cuando hay colores duplicados en el código secreto.
* **Inyección de Dependencias:** El código secreto se inyecta en el motor del juego a través del constructor, lo que facilita enormemente las pruebas y el mantenimiento.
* **Seguridad y Robustez:** * Uso de `Enums` para definir los colores permitidos.
    * Uso de `Optional<Color>` para gestionar entradas de usuario incorrectas sin que el programa falle.
    * Uso de `Collections.unmodifiableList` para proteger la combinación secreta de modificaciones externas.

## Estructura del Código

El código está organizado en las siguientes clases:

1.  **`Main`**: Gestiona la entrada y salida de datos (interfaz de consola).
2.  **`MastermindGame`**: Controla el flujo de la partida (intentos, victoria, fin de juego).
3.  **`MoveEvaluator`**: Realiza los cálculos matemáticos de las bolas blancas y negras.
4.  **`SecretCode`**: Genera y protege la combinación secreta aleatoria.
5.  **`Color`**: Define los colores disponibles y su traducción.
6.  **`RoundResult`**: Transporta el resultado de cada turno de forma limpia.

## Cómo jugar
1. El programa genera una clave secreta de 4 colores.
2. Tienes **10 intentos** para adivinarla.
3. Introduce los colores uno a uno (puedes usar español o inglés: rojo, blue, verde, etc.).
4. El juego te indicará cuántas **Blancas** (color y posición correctos) y cuántas **Negras** (color correcto pero posición incorrecta) tienes.