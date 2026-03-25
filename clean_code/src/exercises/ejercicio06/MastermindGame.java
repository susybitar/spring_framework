package exercises.ejercicio06;

import java.util.List;

/**
 * Gestiona el flujo principal y las reglas del juego Mastermind.
 * Esta clase coordina los intentos del jugador, mantiene el estado de la partida
 * y determina las condiciones de finalización, delegando la lógica compleja.
 */
public class MastermindGame {

    /** Límite máximo de intentos permitidos para adivinar la combinación. */
    public static final int MAX_ATTEMPTS = 10;

    /** Secuencia de colores que el jugador debe descubrir. */
    private final SecretCode secretCode;

    /** Contador de intentos consumidos por el jugador. */
    private int attempts;

    /**
     * Inicializa una nueva partida con una secuencia secreta específica.
     * Aplica Inyección de Dependencias para facilitar pruebas (testing) y flexibilizar el juego.
     *
     * @param secretCode El código secreto que se usará en esta partida.
     */
    public MastermindGame(SecretCode secretCode) {
        this.secretCode = secretCode;
        this.attempts = 0;
    }

    /**
     * Procesa un intento del jugador y actualiza el progreso de la partida.
     *
     * @param userAttempt Lista de colores proporcionada por el usuario.
     * @return Un objeto {@link RoundResult} con el resultado de la evaluación.
     * @throws IllegalStateException Si se intenta jugar habiendo agotado los intentos permitidos.
     */
    public RoundResult checkAttempt(List<Color> userAttempt) {
        // Cláusula de guarda para la robustez del juego
        if (attempts >= MAX_ATTEMPTS) {
            throw new IllegalStateException("Acción no permitida: Se ha alcanzado el máximo de " + MAX_ATTEMPTS + " intentos.");
        }

        // Delegamos el cálculo completo al MoveEvaluator
        RoundResult result = MoveEvaluator.evaluate(secretCode.getSecretSequence(), userAttempt);

        this.attempts++;

        return result;
    }

    /**
     * Determina si la partida ha terminado, ya sea por victoria o por agotar turnos.
     *
     * @param lastResult El resultado del último movimiento realizado.
     * @return true si el juego ha finalizado; false en caso contrario.
     */
    public boolean isGameOver(RoundResult lastResult) {
        return isVictory(lastResult) || attempts >= MAX_ATTEMPTS;
    }

    /**
     * Verifica si el jugador ha logrado la victoria.
     * Aplica el principio "Tell, Don't Ask": el juego no extrae datos, pide al objeto que responda.
     *
     * @param lastResult El resultado a evaluar.
     * @return true si el resultado es una coincidencia perfecta.
     */
    public boolean isVictory(RoundResult lastResult) {
        return lastResult.isPerfectMatch();
    }

    /**
     * Calcula cuántos intentos le quedan al jugador antes de perder.
     *
     * @return Número de intentos restantes.
     */
    public int getAttemptsLeft() {
        return MAX_ATTEMPTS - attempts;
    }

    /**
     * Permite consultar el código secreto (útil para mostrarlo al final de la partida).
     *
     * @return La secuencia de colores secreta.
     */
    public SecretCode getSecretCode() {
        return secretCode;
    }
}