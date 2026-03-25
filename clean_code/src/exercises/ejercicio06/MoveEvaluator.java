package exercises.ejercicio06;

import java.util.List;

/**
 * Motor de evaluación del juego Mastermind.
 * Se encarga de comparar el intento del jugador con el código secreto,
 * calculando los aciertos exactos (blancas) y los aciertos de color (negras).
 */
public class MoveEvaluator {

    /**
     * Longitud estándar de la combinación secreta.
     */
    public static final int CODE_LENGTH = 4;

    /**
     * Evalúa un intento completo contra el código secreto.
     * Actúa como método "Fachada", ocultando la complejidad de los
     * arrays de control interno y garantizando el orden correcto de cálculo.
     *
     * @param secret  La lista de colores de la combinación secreta.
     * @param attempt La lista de colores propuesta por el jugador.
     * @return Un objeto {@link RoundResult} con el recuento final de bolas blancas y negras.
     */
    public static RoundResult evaluate(List<Color> secret, List<Color> attempt) {
        // Arrays para marcar qué posiciones ya han sido emparejadas
        boolean[] secretUsed = new boolean[CODE_LENGTH];
        boolean[] attemptUsed = new boolean[CODE_LENGTH];

        // Primero se calculan las blancas y luego las negras
        int whites = countWhiteBalls(secret, attempt, secretUsed, attemptUsed);
        int blacks = countBlackBalls(secret, attempt, secretUsed, attemptUsed);

        return new RoundResult(whites, blacks);
    }

    /**
     * Cuenta las bolas blancas (mismo color, misma posición).
     * Los métodos de conteo  son privados por seguridad.
     */
    private static int countWhiteBalls(List<Color> secret, List<Color> attempt,
                                       boolean[] secretUsed, boolean[] attemptUsed) {
        int whites = 0;

        for (int i = 0; i < CODE_LENGTH; i++) {
            // Nota: Con los Enum es seguro y óptimo usar '==' en lugar de '.equals()'
            if (secret.get(i) == attempt.get(i)) {
                whites++;
                secretUsed[i] = true;
                attemptUsed[i] = true;
            }
        }
        return whites;
    }

    /**
     * Cuenta las bolas negras (color correcto en posición incorrecta).
     * Solo evalúa las posiciones del intento que no fueron aciertos exactos.
     */
    private static int countBlackBalls(List<Color> secret, List<Color> attempt,
                                       boolean[] secretUsed, boolean[] attemptUsed) {
        int blacks = 0;

        for (int i = 0; i < CODE_LENGTH; i++) {
            // Si la bola del intento no se usó para una blanca, buscamos si su color está en el secreto
            if (!attemptUsed[i]) {
                if (findAndMarkColorMatch(secret, attempt.get(i), secretUsed)) {
                    blacks++;
                }
            }
        }
        return blacks;
    }

    /**
     * Busca un color específico dentro del código secreto que no haya sido usado aún.
     * Si lo encuentra, lo marca como usado y devuelve true.
     * Extracción de método para reducir la anidación y mejorar la legibilidad.
     *
     * @param secret      La lista de colores secretos.
     * @param targetColor El color que estamos buscando.
     * @param secretUsed  El array de posiciones ya usadas en el secreto.
     * @return true si encuentra una coincidencia disponible, false en caso contrario.
     */
    private static boolean findAndMarkColorMatch(List<Color> secret, Color targetColor, boolean[] secretUsed) {
        for (int j = 0; j < CODE_LENGTH; j++) {
            if (!secretUsed[j] && secret.get(j) == targetColor) {
                secretUsed[j] = true; // Marcamos para no volver a contar esta misma bola
                return true;
            }
        }
        return false;
    }
}