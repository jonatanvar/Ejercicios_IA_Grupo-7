package Ejercicio029;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 029 | 2025-10-15
 */
public class Ejercicio029_Main {

    private static final int MSG_ENTRADA = 11;
    private static final int MSG_FINALIZACION = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio029_Utilidades.mostrarSelloCorto();

        Ejercicio029_Utilidades.seleccionarIdioma(scanner);

        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio029_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            Ejercicio029_Utilidades.mostrarEncabezado();

            double suma = 0.0;
            int contador = 0;
            int centinela = Ejercicio029_Utilidades.getCentinela();

            int numero = Ejercicio029_Utilidades.leerEntero(scanner, Ejercicio029_Utilidades.obtenerTexto(MSG_ENTRADA));

            for ( ; numero != centinela; ) {
                suma += numero;
                contador++;

                numero = Ejercicio029_Utilidades.leerEntero(scanner, Ejercicio029_Utilidades.obtenerTexto(MSG_ENTRADA));
            }

            double promedio = Ejercicio029_Operaciones.calcularPromedio(suma, contador);

            Ejercicio029_Utilidades.mostrarResultado(promedio, contador);

            System.out.println();
        }

        scanner.close();
        System.out.println(Ejercicio029_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}