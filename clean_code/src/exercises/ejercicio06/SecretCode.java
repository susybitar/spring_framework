package exercises.ejercicio06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Representa la secuencia secreta de colores que el jugador debe adivinar.
 * Centraliza la generación aleatoria y asegura que la combinación
 * creada sea inmutable para proteger la integridad de la partida.
 */
public class SecretCode {

    /** Lista interna que almacena la combinación ganadora. */
    private final List<Color> secretSequence;

    /**
     * Constructor. Genera la combinación aleatoria automáticamente al instanciar la clase.
     * Utiliza la longitud definida globalmente en MoveEvaluator.
     */
    public SecretCode() {
        // Inicializamos con la capacidad exacta que vamos a usar para no desperdiciar memoria
        this.secretSequence = new ArrayList<>(MoveEvaluator.CODE_LENGTH);
        generateRandomSequence();
    }

    /**
     * Método privado de apoyo encargado de poblar la lista con colores aleatorios.
     * Extraer la lógica del bucle a este método hace que el constructor sea más limpio.
     */
    private void generateRandomSequence() {
        // La herramienta Random ahora es local: hace su trabajo y se elimina de la memoria
        Random random = new Random();
        Color[] availableColors = Color.values();

        for (int i = 0; i < MoveEvaluator.CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(availableColors.length);
            secretSequence.add(availableColors[randomIndex]);
        }
    }

    /**
     * Devuelve la secuencia secreta protegiéndola contra modificaciones externas.
     * * @return Una vista inmodificable (solo lectura) de la lista de colores secretos.
     */
    public List<Color> getSecretSequence() {
        // Copia defensiva: si alguien intenta hacer un .clear() o .add() sobre
        // el resultado de este método, Java lanzará una excepción, protegiendo el código.
        return Collections.unmodifiableList(secretSequence);
    }
}