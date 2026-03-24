package exercises.ejercicio01;

/**
 * Clase que contiene utilidades lógicas básicas.
 * Se ha refactorizado para eliminar redundancias booleanas.
 */
public class Ejercicio01 {

    /**
     * Compara dos numeros enteros para determinar si el primero es estrictamente mayor que el segundo.
     * * @param a El primer número a comparar.
     *
     * @param b El segundo numero a comparar.
     * @return true si 'a' es mayor que 'b', false en caso contrario.
     */
    public boolean isGreater(int a, int b) {
        // Refactorizacion: Se elimina el if/else innecesario y se devuelve directamente la expresion.
        return a > b;
    }
}