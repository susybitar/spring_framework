package exercises.ejercicio03;

public class Ejercicio03 {

    public void calcularEcuacionSegundoGrado(double a, double b, double c) {

        // 1. Calculamos el discriminante con un nombre descriptivo
        double discriminante = (b * b) - (4 * a * c);

        // 2. Cláusula Guarda: Si no hay raíces reales, salimos.
        if (discriminante < 0) {
            System.out.println("La ecuación no tiene raíces reales");
            return;
        }

        // 3. Cláusula Guarda: Si solo hay una raíz.
        if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("La ecuación tiene una única raíz: x = " + x);
            return;
        }

        // 4. Caso final: Si llega aquí, hay dos raíces.
        double x1 = (-b - Math.sqrt(discriminante)) / (2 * a);
        double x2 = (-b + Math.sqrt(discriminante)) / (2 * a);

        System.out.println("La ecuación tiene dos raíces: x1 = " + x1 + ", x2 = " + x2);
    }
}