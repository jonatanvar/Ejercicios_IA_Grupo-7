package Ejercicio024;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 024 | 2025-10-15
 */
public class Ejercicio024_Main {

    private static final int MSG_LADO_A = 11;
    private static final int MSG_LADO_B = 12;
    private static final int MSG_LADO_C = 13;
    private static final int MSG_FINALIZACION = 18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio024_Utilidades.mostrarSelloCorto();
        Ejercicio024_Utilidades.seleccionarIdioma(scanner);
        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio024_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }
            Ejercicio024_Utilidades.mostrarEncabezado();
            double ladoA = Ejercicio024_Utilidades.leerDoublePositivo(scanner, Ejercicio024_Utilidades.obtenerTexto(MSG_LADO_A));
            double ladoB = Ejercicio024_Utilidades.leerDoublePositivo(scanner, Ejercicio024_Utilidades.obtenerTexto(MSG_LADO_B));
            double ladoC = Ejercicio024_Utilidades.leerDoublePositivo(scanner, Ejercicio024_Utilidades.obtenerTexto(MSG_LADO_C));

            boolean esTriangulo = Ejercicio024_Operaciones.esTriangulo(ladoA, ladoB, ladoC);

            Ejercicio024_Utilidades.mostrarResultado(esTriangulo);

            System.out.println();
        }
        scanner.close();
        System.out.println(Ejercicio024_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}