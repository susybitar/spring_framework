package exercises.ejercicio06;

import java.util.Optional;

/**
 * Define los colores permitidos para las piezas del juego Mastermind.
 * Asocia cada color con su representación en texto para facilitar
 * la entrada de datos por parte del usuario.
 */
public enum Color {
    BLUE("azul"),
    RED("rojo"),
    GREEN("verde"),
    YELLOW("amarillo");

    /**
     * Representación del color en español.
     */
    private final String spanishName;

    /**
     * Constructor del Enum.
     *
     * @param spanishName El nombre del color escrito en español.
     */
    Color(String spanishName) {
        this.spanishName = spanishName;
    }

    /**
     * Convierte una entrada de texto al valor correspondiente del Enum.
     * Soporta tanto el nombre en español ("azul") como en inglés ("blue").
     * Utiliza Optional para obligar a gestionar los casos en los que el texto no es válido.
     *
     * @param text Nombre del color introducido por el usuario.
     * @return Un {@link Optional} con el color encontrado, o vacío si no coincide.
     */
    public static Optional<Color> fromString(String text) {
        if (text == null || text.trim().isEmpty()) {
            return Optional.empty();
        }

        String normalizedText = text.trim();

        // Recorremos los colores para ver si el texto coincide con alguno
        for (Color color : Color.values()) {
            // Comprobamos si coincide con el español o con el nombre interno (inglés)
            // Usamos equalsIgnoreCase para no tener problemas con mayúsculas/minúsculas
            if (color.spanishName.equalsIgnoreCase(normalizedText) ||
                    color.name().equalsIgnoreCase(normalizedText)) {
                return Optional.of(color);
            }
        }

        return Optional.empty();
    }

    /**
     * Valida de forma rápida si un texto introducido corresponde a un color del juego.
     *
     * @param text El texto a comprobar.
     * @return true si el color existe y es válido, false en caso contrario.
     */
    public static boolean isValidColor(String text) {
        return fromString(text).isPresent();
    }
}