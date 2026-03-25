package exercises.ejercicio06;

/**
 * Representa el resultado de un intento en el juego Mastermind.
 * Contiene el recuento de aciertos exactos (blancas) y de color (negras).
 */
public class RoundResult {

    private final int whiteBalls;
    private final int blackBalls;

    public RoundResult(int whiteBalls, int blackBalls) {
        this.whiteBalls = whiteBalls;
        this.blackBalls = blackBalls;
    }

    public int getWhiteBalls() {
        return whiteBalls;
    }

    public int getBlackBalls() {
        return blackBalls;
    }

    /**
     * Determina si el resultado corresponde a una victoria total.
     *
     * @return true si todas las posiciones son aciertos exactos.
     */
    public boolean isPerfectMatch() {
        return this.whiteBalls == MoveEvaluator.CODE_LENGTH;
    }

    @Override
    public String toString() {
        return String.format("Resultado: %d Blancas (Posición correcta), %d Negras (Color correcto)",
                whiteBalls, blackBalls);
    }
}