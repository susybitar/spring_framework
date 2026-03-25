package exercises.ejercicio06;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Clase principal que actúa como Interfaz de Usuario (Vista) para el juego Mastermind.
 * Se encarga de la interacción por consola, leer entradas y mostrar los mensajes,
 * manteniendo el motor del juego (MastermindGame) libre de esta responsabilidad.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Inicializamos el motor del juego (Inyección de Dependencias)
        SecretCode secretCode = new SecretCode();
        MastermindGame game = new MastermindGame(secretCode);

        System.out.println("========================================");
        System.out.println("      ¡BIENVENIDO A MASTERMIND!         ");
        System.out.println("========================================");
        System.out.println("Adivina el código secreto de " + MoveEvaluator.CODE_LENGTH + " colores.");
        System.out.println("Colores disponibles: Azul, Rojo, Verde, Amarillo.");
        System.out.println("Tienes " + MastermindGame.MAX_ATTEMPTS + " intentos. ¡Suerte!\n");

        RoundResult lastResult = null;

        // 2. Bucle principal del juego
        while (lastResult == null || !game.isGameOver(lastResult)) {
            System.out.println("\n--- Intento " + (MastermindGame.MAX_ATTEMPTS - game.getAttemptsLeft() + 1) + " ---");

            // Le pedimos al usuario los colores
            List<Color> userAttempt = readUserAttempt(scanner);

            // Pasamos el intento al motor y guardamos el resultado
            lastResult = game.checkAttempt(userAttempt);

            // Mostramos el resultado (El toString() que hicimos en RoundResult)
            System.out.println(lastResult.toString());

            // Mostramos cuántos intentos le quedan
            if (!game.isVictory(lastResult) && game.getAttemptsLeft() > 0) {
                System.out.println("Te quedan " + game.getAttemptsLeft() + " intentos.");
            }
        }

        // 3. Fin del juego: Mensajes de Victoria o Derrota
        System.out.println("\n========================================");
        if (game.isVictory(lastResult)) {
            System.out.println("¡ENHORABUENA! Has adivinado el código secreto.");
        } else {
            System.out.println("GAME OVER. Has agotado todos tus intentos.");
            System.out.println("El código secreto era: " + game.getSecretCode().getSecretSequence());
        }
        System.out.println("========================================");

        scanner.close();
    }

    /**
     * Pide al usuario que introduzca los colores uno por uno de forma segura.
     * Si el usuario escribe un color inválido, se le vuelve a pedir.
     *
     * @param scanner El lector de teclado.
     * @return Una lista validada de colores listos para el motor del juego.
     */
    private static List<Color> readUserAttempt(Scanner scanner) {
        List<Color> attempt = new ArrayList<>(MoveEvaluator.CODE_LENGTH);

        System.out.println("Introduce los " + MoveEvaluator.CODE_LENGTH + " colores uno a uno:");

        while (attempt.size() < MoveEvaluator.CODE_LENGTH) {
            System.out.print("Color " + (attempt.size() + 1) + ": ");
            String input = scanner.nextLine();

            // Usamos nuestro Optional para traducir el texto a un Color de forma segura
            Optional<Color> parsedColor = Color.fromString(input);

            if (parsedColor.isPresent()) {
                attempt.add(parsedColor.get());
            } else {
                System.out.println("Color inválido. Recuerda: Azul, Rojo, Verde, Amarillo.");
            }
        }

        return attempt;
    }
}